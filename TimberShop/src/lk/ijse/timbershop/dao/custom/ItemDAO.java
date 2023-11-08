package lk.ijse.timbershop.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.CusCartDetails;
import lk.ijse.timbershop.to.Item;
import lk.ijse.timbershop.to.SupCartDetails;
import lk.ijse.timbershop.view.tm.ItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String> {
    ObservableList<ItemTm> getItemDetails() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;
    boolean updateQty(ArrayList<CusCartDetails> orderDetails) throws SQLException, ClassNotFoundException;
    boolean updateQty(Item item) throws SQLException, ClassNotFoundException;
    boolean updateQty1(Item item ) throws SQLException, ClassNotFoundException;
    boolean updateQty1(ArrayList<SupCartDetails> supCartDetails) throws SQLException, ClassNotFoundException;
}
