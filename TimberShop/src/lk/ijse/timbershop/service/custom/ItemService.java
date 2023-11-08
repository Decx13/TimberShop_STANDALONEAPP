package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.Item;

import java.sql.SQLException;

public interface ItemService extends SuperService {
    boolean add(Item item) throws SQLException, ClassNotFoundException;
    boolean updateItem(Item item) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
    Item search(String ItemCode) throws SQLException, ClassNotFoundException;
}
