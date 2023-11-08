package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.ItemDAO;
import lk.ijse.timbershop.dao.custom.SupplierDAO;
import lk.ijse.timbershop.dao.custom.SupplierOrderDAO;
import lk.ijse.timbershop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.timbershop.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.timbershop.dao.custom.impl.SupplierOrderDAOImpl;
import lk.ijse.timbershop.service.custom.SupplierOrderService;
import lk.ijse.timbershop.to.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierOrderServiceImpl implements SupplierOrderService {
    SupplierOrderDAO supplierOrderDAO= DaoFactory.getInstance().getDao(DaoType.SUPPLIERORDER);
    ItemDAO itemDAO=DaoFactory.getInstance().getDao(DaoType.ITEM);
    SupplierDAO supplierDAO=DaoFactory.getInstance().getDao(DaoType.SUPPLIER);

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return supplierOrderDAO.generateNextOrderId();
    }

    @Override
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        return itemDAO.loadItemCodes();
    }

    @Override
    public Item search(String ItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.search(ItemCode);
    }

    @Override
    public ArrayList<String> loadSupplierIds() throws SQLException, ClassNotFoundException {
        return supplierDAO.loadSupplierIds();
    }
}
