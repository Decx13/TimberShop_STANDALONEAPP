package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.CustomerDAO;
import lk.ijse.timbershop.dao.custom.CustomerOrderDAO;
import lk.ijse.timbershop.dao.custom.ItemDAO;
import lk.ijse.timbershop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.timbershop.dao.custom.impl.CustomerOrderDAOImpl;
import lk.ijse.timbershop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.timbershop.service.custom.CustomerOrderService;
import lk.ijse.timbershop.to.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerOrderServiceImpl implements CustomerOrderService {
    ItemDAO itemDAO= DaoFactory.getInstance().getDao(DaoType.ITEM);
    CustomerDAO customerDAO=DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
    CustomerOrderDAO customerOrderDAO=DaoFactory.getInstance().getDao(DaoType.CUSTOMERORDER);


    @Override
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        return itemDAO.loadItemCodes();
    }

    @Override
    public Item search(String ItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.search(ItemCode);
    }

    @Override
    public ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        return customerDAO.loadCustomerIds();
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return customerOrderDAO.generateNextOrderId();
    }
}
