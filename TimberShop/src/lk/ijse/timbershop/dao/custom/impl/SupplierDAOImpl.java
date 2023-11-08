package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.SupplierDAO;
import lk.ijse.timbershop.db.DBConnection;
import lk.ijse.timbershop.to.Supplier;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public boolean add(Supplier supplier) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Supplier VALUES(?,?,?,?)";
        return(boolean) CrudUtil.execute(sql,new Object[]{supplier.getSupplierId(),supplier.getName(),supplier.getAddress(),supplier.getNumber()});

    }

    @Override
    public boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
        return (boolean) CrudUtil.execute("UPDATE Supplier SET Name=?,Address=?,Number=? WHERE SupplierId=?",supplier.getName(),supplier.getAddress(),supplier.getNumber(),supplier.getSupplierId());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM Supplier WHERE SupplierId='"+id+"'")>0;

    }

    @Override
    public Supplier search(String SupplierId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Supplier WHERE SupplierId = ?";
        ResultSet result = (ResultSet)CrudUtil.execute(sql, new Object[]{SupplierId});
        return result.next() ? new Supplier(result.getString(1), result.getString(2), result.getString(3), result.getString(4)) : null;

    }

    @Override
    public ArrayList<String> loadSupplierIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT SupplierId FROM Supplier";
        ResultSet result = (ResultSet)CrudUtil.execute(sql, new Object[0]);
        ArrayList<String> idList = new ArrayList();

        while(result.next()) {
            idList.add(result.getString(1));
        }

        return idList;
    }
}
