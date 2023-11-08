package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.UserDAO;
import lk.ijse.timbershop.to.User;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO User VALUES (?, ?)";
        return (Boolean) CrudUtil.execute(sql, new Object[]{user.getUsername(), user.getPassword() });
    }

    @Override
    public boolean update(User obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean delete(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");
    }

    @Override
    public User search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");
    }
}
