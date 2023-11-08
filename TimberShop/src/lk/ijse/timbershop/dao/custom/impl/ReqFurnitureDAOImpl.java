package lk.ijse.timbershop.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.timbershop.dao.custom.ReqFurnitureDAO;
import lk.ijse.timbershop.db.DBConnection;
import lk.ijse.timbershop.to.ReqFurniture;
import lk.ijse.timbershop.util.CrudUtil;
import lk.ijse.timbershop.view.tm.ReqFurnitureTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReqFurnitureDAOImpl implements ReqFurnitureDAO {
    @Override
    public boolean add(ReqFurniture reqFurniture) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO ReqFurniture VALUES (?, ?, ?, ?,?,?)";
        return (Boolean) CrudUtil.execute(sql, new Object[]{reqFurniture.getReqId(), reqFurniture.getFurnitureId(), reqFurniture.getCustomerId(), reqFurniture.getDate(),reqFurniture.getReqDate(),reqFurniture.getPrice() });

    }

    @Override
    public boolean update(ReqFurniture reqFurniture) throws SQLException, ClassNotFoundException {
        return (boolean) CrudUtil.execute("UPDATE Reqfurniture SET FurnitureId=?,CustomerId=?,Date=?,ReqDate=?,Price=? WHERE ReqId=?",reqFurniture.getFurnitureId(),reqFurniture.getCustomerId(),reqFurniture.getDate(),reqFurniture.getReqDate(),reqFurniture.getPrice(),reqFurniture.getReqId() );

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM Reqfurniture WHERE ReqId='"+id+"'")>0;

    }

    @Override
    public ReqFurniture search(String ReqId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Reqfurniture WHERE ReqId=?";
        ResultSet result = (ResultSet) CrudUtil.execute(sql,ReqId);
        return result.next() ? new ReqFurniture(result.getString(1), result.getString(2), result.getString(3), result.getDate(4),result.getDate(5),result.getDouble(6)) : null;


    }

    @Override
    public ArrayList<String> loadReqIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT ReqId FROM ReqFurniture";
        ResultSet result = (ResultSet)CrudUtil.execute(sql, new Object[0]);
        ArrayList<String> idList = new ArrayList();

        while(result.next()) {
            idList.add(result.getString(1));
        }

        return idList;
    }

    @Override
    public ObservableList<ReqFurnitureTm> getReqetails() throws SQLException, ClassNotFoundException {
        ResultSet rs=CrudUtil.execute("SELECT * FROM Reqfurniture");
        ObservableList<ReqFurnitureTm> list = FXCollections.observableArrayList();
        while (rs.next()){
            list.add(new ReqFurnitureTm(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getDouble(5)));
        }
        return list;
    }
}
