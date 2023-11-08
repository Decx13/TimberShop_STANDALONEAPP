package lk.ijse.timbershop.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.IncomeDAO;
import lk.ijse.timbershop.dao.custom.impl.IncomeDAOImpl;
import lk.ijse.timbershop.service.custom.MonthlyIncomeService;
import lk.ijse.timbershop.to.IncomeTM;

import java.sql.SQLException;

public class MonthlyIncomeServiceImpl implements MonthlyIncomeService {
    IncomeDAO incomeDAO= DaoFactory.getInstance().getDao(DaoType.INCOME);

    @Override
    public ObservableList<IncomeTM> getDailyIncome(int month, int year) throws SQLException, ClassNotFoundException {
        return incomeDAO.getDailyIncome(month, year);
    }
}
