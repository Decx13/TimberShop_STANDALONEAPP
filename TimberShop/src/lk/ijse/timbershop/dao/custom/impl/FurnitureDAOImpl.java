package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.FurnitureDAO;
import lk.ijse.timbershop.dao.custom.ReqFurnitureDAO;
import lk.ijse.timbershop.db.DBConnection;
import lk.ijse.timbershop.to.Furniture;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FurnitureDAOImpl implements FurnitureDAO {
    @Override
    public boolean add(Furniture furniture) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Furniture VALUES (?, ?, ?, ?)";
        return (Boolean) CrudUtil.execute(sql, new Object[]{furniture.getFurnitureId(), furniture.getName(), furniture.getStyle(), furniture.getPrice() });

    }

    @Override
    public boolean update(Furniture furniture) throws SQLException, ClassNotFoundException {
        return (boolean) CrudUtil.execute("UPDATE Furniture SET Name=?,Style=?,Price=? WHERE FurnitureId=?",furniture.getName(),furniture.getStyle(),furniture.getPrice(),furniture.getFurnitureId());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM Furniture WHERE FurnitureId='"+id+"'")>0;

    }

    @Override
    public Furniture search(String FurnitureId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Furniture WHERE FurnitureID=?";
        ResultSet result = (ResultSet) CrudUtil.execute(sql, new Object[]{FurnitureId});
        return result.next() ? new Furniture(result.getString(1), result.getString(2), result.getString(3), result.getDouble(4)) : null;


    }

    @Override
    public ArrayList<String> loadFurnitureIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT FurnitureId FROM Furniture ";
        ResultSet result = (ResultSet)CrudUtil.execute(sql, new Object[0]);
        ArrayList<String> idList = new ArrayList();

        while(result.next()) {
            idList.add(result.getString(1));
        }

        return idList;
    }
}
