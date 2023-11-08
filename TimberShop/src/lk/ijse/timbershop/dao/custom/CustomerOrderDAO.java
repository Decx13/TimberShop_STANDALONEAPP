package lk.ijse.timbershop.dao.custom;

import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.CustomerOrder;

import java.sql.SQLException;

public interface CustomerOrderDAO extends CrudDAO<CustomerOrder,String> {
    String generateNextOrderId() throws SQLException, ClassNotFoundException;
    String generateNextOrderId(String currentOrderId);
}
