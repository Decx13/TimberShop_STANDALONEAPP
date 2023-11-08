package lk.ijse.timbershop.dao.custom;

import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.SupplierOrder;

import java.sql.SQLException;

public interface SupplierOrderDAO extends CrudDAO<SupplierOrder,String> {
    String generateNextOrderId() throws SQLException, ClassNotFoundException;
    String generateNextOrderId(String currentOrderId);
}
