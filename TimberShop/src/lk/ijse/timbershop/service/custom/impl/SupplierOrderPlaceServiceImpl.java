package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.ItemDAO;
import lk.ijse.timbershop.dao.custom.SorderDetailDAO;
import lk.ijse.timbershop.dao.custom.SupplierOrderDAO;
import lk.ijse.timbershop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.timbershop.dao.custom.impl.SorderDetailDAOImpl;
import lk.ijse.timbershop.dao.custom.impl.SupplierOrderDAOImpl;
import lk.ijse.timbershop.db.DBConnection;

import lk.ijse.timbershop.service.custom.SupplierOrderPlaceService;
import lk.ijse.timbershop.to.SupplierOrder;
import lk.ijse.timbershop.to.SupplierOrderPlace;

import java.sql.SQLException;
import java.time.LocalDate;

public class SupplierOrderPlaceServiceImpl implements SupplierOrderPlaceService {
    SupplierOrderDAO supplierOrderDAO = DaoFactory.getInstance().getDao(DaoType.SUPPLIERORDER);
    ItemDAO itemDAO=DaoFactory.getInstance().getDao(DaoType.ITEM);
    SorderDetailDAO sorderDetailDAO=DaoFactory.getInstance().getDao(DaoType.SORDERDETAIL);

    @Override
    public boolean SupplierPlaceOrder(SupplierOrderPlace supplierOrderPlace) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);

            boolean isOrderAdded = supplierOrderDAO.add(new SupplierOrder(supplierOrderPlace.getS_orderId(), supplierOrderPlace.getSupplierId(), LocalDate.now()));
            boolean isUpdated;
            if (isOrderAdded) {
                isUpdated = itemDAO.updateQty1(supplierOrderPlace.getOrderDetails1());
                if (isUpdated) {
                    boolean isOrderDetailAdded = sorderDetailDAO.saveOrderDetails(supplierOrderPlace.getOrderDetails1());
                    if (isOrderDetailAdded) {
                        DBConnection.getInstance().getConnection().commit();
                        //boolean var4=true;
                        //return var4;
                        return true;
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            //isUpdated=false;
            return false;
        }catch (SQLException|ClassNotFoundException e){
            DBConnection.getInstance().getConnection().rollback();
            throw e;

        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }
}
