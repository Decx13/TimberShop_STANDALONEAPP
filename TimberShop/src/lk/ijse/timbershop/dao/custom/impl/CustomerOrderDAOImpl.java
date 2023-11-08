package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.CustomerOrderDAO;
import lk.ijse.timbershop.to.CustomerOrder;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOrderDAOImpl implements CustomerOrderDAO {
    @Override
    public boolean add(CustomerOrder customerOrder) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO CustomerOrder VALUES (?,?,?)";
        return(Boolean)CrudUtil.execute(sql,new Object[]{customerOrder.getCorderId(),customerOrder.getDate(),customerOrder.getCustomerId()});

    }

    @Override
    public boolean update(CustomerOrder obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean delete(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");

    }

    @Override
    public CustomerOrder search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");

    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT C_orderId FROM CustomerOrder ORDER BY C_orderId DESC LIMIT 1";
        ResultSet result = (ResultSet) CrudUtil.execute(sql, new Object[0]);
        return result.next() ? generateNextOrderId(result.getString(1)) : generateNextOrderId(result.getString((String)null));

    }

    @Override
    public String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("D0");
            int id = Integer.parseInt(split[1]);
            ++id;
            return "D0" + id;
        } else {
            return "0001";
        }
    }
}
