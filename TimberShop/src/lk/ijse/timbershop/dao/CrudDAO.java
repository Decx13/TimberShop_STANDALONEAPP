package lk.ijse.timbershop.dao;

import java.sql.SQLException;

public interface CrudDAO<T,ID> extends SuperDAO{
    boolean add(T obj) throws SQLException,ClassNotFoundException;
    boolean update(T obj) throws SQLException,ClassNotFoundException;
    boolean delete(String obj) throws  SQLException,ClassNotFoundException;
    T search(String ID) throws SQLException,ClassNotFoundException;

}
