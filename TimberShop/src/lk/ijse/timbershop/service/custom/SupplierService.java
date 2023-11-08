package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.Supplier;

import java.sql.SQLException;

public interface SupplierService extends SuperService {
    boolean add(Supplier supplier) throws SQLException, ClassNotFoundException;
    Supplier search(String SupplierId) throws SQLException, ClassNotFoundException;
    boolean updateSupplier(Supplier supplier) throws SQLException, ClassNotFoundException;
    boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException;
}
