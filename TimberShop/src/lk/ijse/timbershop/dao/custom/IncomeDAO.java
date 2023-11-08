package lk.ijse.timbershop.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.IncomeTM;

import java.sql.SQLException;

public interface IncomeDAO extends CrudDAO<IncomeTM,String> {
    ObservableList<IncomeTM> getDailyIncome(int month, int year) throws SQLException, ClassNotFoundException;
}
