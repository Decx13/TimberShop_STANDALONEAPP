package lk.ijse.timbershop.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.timbershop.dao.custom.IncomeDAO;
import lk.ijse.timbershop.to.IncomeTM;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IncomeDAOImpl implements IncomeDAO {
    @Override
    public boolean add(IncomeTM obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("add function not available");
    }

    @Override
    public boolean update(IncomeTM obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean delete(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");
    }

    @Override
    public IncomeTM search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");
    }

    @Override
    public ObservableList<IncomeTM> getDailyIncome(int month, int year) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("select co.date as date,Count(co.C_orderId) as count , " +
                "sum(cod.Qty*cod.Unitprice) as total,Day(co.Date) as day,Month(co.date) as month , Year(co.date) as" +
                " year from C_orderdetail cod inner join customerorder co on cod.C_orderId = co.C_orderId" +
                " group by co.date having month = ? and year = ?",month,year);
        ObservableList<IncomeTM> list = FXCollections.observableArrayList();
        while (rs.next()){
            list.add(new IncomeTM(rs.getString(1),rs.getInt(2),rs.getDouble(3)));
        }
        return list;
    }
}
