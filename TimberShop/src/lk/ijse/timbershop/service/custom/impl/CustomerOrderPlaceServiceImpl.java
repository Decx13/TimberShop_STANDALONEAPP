package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.CorderDetailDAO;
import lk.ijse.timbershop.dao.custom.CustomerOrderDAO;
import lk.ijse.timbershop.dao.custom.ItemDAO;
import lk.ijse.timbershop.dao.custom.impl.CorderDetailDAOImpl;
import lk.ijse.timbershop.dao.custom.impl.CustomerOrderDAOImpl;
import lk.ijse.timbershop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.timbershop.db.DBConnection;



import lk.ijse.timbershop.service.custom.CustomerOrderPlaceService;
import lk.ijse.timbershop.to.CustomerOrder;
import lk.ijse.timbershop.to.CustomerOrderPlace;

import java.sql.SQLException;
import java.time.LocalDate;

public class CustomerOrderPlaceServiceImpl implements CustomerOrderPlaceService {
    CustomerOrderDAO customerOrderDAO= DaoFactory.getInstance().getDao(DaoType.CUSTOMERORDER);
    ItemDAO itemDAO=DaoFactory.getInstance().getDao(DaoType.ITEM);
    CorderDetailDAO corderDetailDAO=DaoFactory.getInstance().getDao(DaoType.CORDERDETAIL);
    @Override
    public boolean CustomerPlaceOrder(CustomerOrderPlace customerOrderPlace) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);

            boolean isOrderAdded = customerOrderDAO.add(new CustomerOrder(customerOrderPlace.getCorderId(), LocalDate.now(), customerOrderPlace.getCustomerId()));
            // System.out.println(isOrderAdded);
            boolean isUpdated;
            if (isOrderAdded) {
                isUpdated = itemDAO.updateQty(customerOrderPlace.getOrderDetails());
                //System.out.println(isUpdated +" is Updated");
                if (isUpdated) {
                    boolean isOrderDetailAdded = corderDetailDAO.saveOrderDetails(customerOrderPlace.getOrderDetails());
                    System.out.println(isOrderDetailAdded + "  is Order Added");
                    if (isOrderDetailAdded) {
                        DBConnection.getInstance().getConnection().commit();
                        //boolean var4=true;
                        return true;
                    }
                }

            }
            //System.out.println(isOrderAdded);


            DBConnection.getInstance().getConnection().rollback();
            return false;
            //isUpdated=false;
            //return isUpdated;
        }catch (SQLException|ClassNotFoundException e){
            DBConnection.getInstance().getConnection().rollback();
            throw e;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
