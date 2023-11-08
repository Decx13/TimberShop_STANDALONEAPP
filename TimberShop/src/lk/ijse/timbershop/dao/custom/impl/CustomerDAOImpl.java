package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.CustomerDAO;
import lk.ijse.timbershop.db.DBConnection;
import lk.ijse.timbershop.to.Customer;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?)";
        return (Boolean) CrudUtil.execute(sql, new Object[]{customer.getCustomerId(), customer.getName(), customer.getAddress(), customer.getNumber() });
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return (boolean) CrudUtil.execute("UPDATE Customer SET Name=?,Address=?,Number=? WHERE CustomerId=?",customer.getName(),customer.getAddress(),customer.getNumber(),customer.getCustomerId());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM Customer WHERE CustomerId='"+id+"'")>0;
    }

    @Override
    public Customer search(String CustomerId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Customer WHERE CustomerID=?";
        ResultSet result = (ResultSet) CrudUtil.execute(sql, new Object[]{CustomerId});
        return result.next() ? new Customer(result.getString(1), result.getString(2), result.getString(3), result.getString(4)) : null;
    }


    @Override
    public ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT CustomerId FROM Customer";
        ResultSet result = (ResultSet)CrudUtil.execute(sql, new Object[0]);
        ArrayList<String> idList = new ArrayList();

        while(result.next()) {
            idList.add(result.getString(1));
        }

        return idList;
    }
}
