package lk.ijse.timbershop.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.view.tm.ItemTm;

import java.sql.SQLException;

public interface OrderFormService extends SuperService {
    ObservableList<ItemTm> getItemDetails() throws SQLException, ClassNotFoundException;
}
