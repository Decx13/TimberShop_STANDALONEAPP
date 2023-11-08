package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierOrderService extends SuperService {
    String generateNextOrderId() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;
    Item search(String ItemCode) throws SQLException, ClassNotFoundException;
    ArrayList<String> loadSupplierIds() throws SQLException, ClassNotFoundException;
}
