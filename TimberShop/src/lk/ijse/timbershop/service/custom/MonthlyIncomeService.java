package lk.ijse.timbershop.service.custom;

import javafx.collections.ObservableList;
import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.IncomeTM;

import java.sql.SQLException;

public interface MonthlyIncomeService extends SuperService {
    ObservableList<IncomeTM> getDailyIncome(int month, int year) throws SQLException, ClassNotFoundException;
}
