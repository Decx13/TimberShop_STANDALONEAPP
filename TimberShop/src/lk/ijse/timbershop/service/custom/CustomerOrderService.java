package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerOrderService extends SuperService {
    ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;
    Item search(String ItemCode) throws SQLException, ClassNotFoundException;
    ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException;
    String generateNextOrderId() throws SQLException, ClassNotFoundException;
}
