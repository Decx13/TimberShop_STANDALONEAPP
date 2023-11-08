package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.SupplierDAO;
import lk.ijse.timbershop.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.timbershop.service.custom.SupplierService;
import lk.ijse.timbershop.to.Supplier;

import java.sql.SQLException;

public class SupplierServiceImpl implements SupplierService {
    SupplierDAO supplierDAO= DaoFactory.getInstance().getDao(DaoType.SUPPLIER);

    @Override
    public boolean add(Supplier supplier) throws SQLException, ClassNotFoundException {
        return supplierDAO.add(supplier);
    }

    @Override
    public Supplier search(String SupplierId) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(SupplierId);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(supplier);
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }
}
