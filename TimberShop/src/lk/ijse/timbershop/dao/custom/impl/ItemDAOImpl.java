package lk.ijse.timbershop.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.timbershop.dao.custom.ItemDAO;
import lk.ijse.timbershop.db.DBConnection;
import lk.ijse.timbershop.to.CusCartDetails;
import lk.ijse.timbershop.to.Item;
import lk.ijse.timbershop.to.SupCartDetails;
import lk.ijse.timbershop.util.CrudUtil;
import lk.ijse.timbershop.view.tm.ItemTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Item VALUES(?,?,?,?)";
        return(boolean) CrudUtil.execute(sql,new Object[]{item.getItemcode(),item.getName(),item.getQty(),item.getUnitprice()});

    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return (boolean) CrudUtil.execute("UPDATE Item SET Name=?,Qty=?,Unitprice=? WHERE Itemcode=?",item.getName(),item.getQty(),item.getUnitprice(),item.getItemcode());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM Item WHERE Itemcode='"+id+"'")>0;

    }

    @Override
    public Item search(String ItemCode ) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Item WHERE Itemcode=?";
        ResultSet result = (ResultSet) CrudUtil.execute(sql, new Object[]{ItemCode});
        return result.next() ? new Item(result.getString(1), result.getString(2), result.getInt(3), result.getDouble(4)) : null;

    }

    @Override
    public ObservableList<ItemTm> getItemDetails() throws SQLException, ClassNotFoundException {
        ResultSet rs=CrudUtil.execute("SELECT * FROM Item");
        ObservableList<ItemTm> list = FXCollections.observableArrayList();
        while (rs.next()){
            list.add(new ItemTm(rs.getString(1),rs.getString(2),rs.getInt(3)));
        }
        return list;
    }

    @Override
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT ItemCode FROM Item";
        ResultSet result = (ResultSet)CrudUtil.execute(sql, new Object[0]);
        ArrayList<String> idList = new ArrayList();

        while(result.next()) {
            idList.add(result.getString(1));
        }

        return idList;
    }

    @Override
    public boolean updateQty(ArrayList<CusCartDetails> orderDetails) throws SQLException, ClassNotFoundException {
        for(CusCartDetails cusCartDetails : orderDetails){
            if(!updateQty(new Item(cusCartDetails.getItemcode(),cusCartDetails.getItemcode(), cusCartDetails.getQty(), cusCartDetails.getUnitprice()))){
                return false;
            }
        }
        /*Iterator var1 = orderDetails.iterator();

        CusCartDetails cusCartDetails;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            cusCartDetails = (CusCartDetails) var1.next();
        } while();*/

        return true;
    }

    @Override
    public boolean updateQty(Item item) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET Qty = Qty - ? WHERE Itemcode = ?";
        //System.out.println(item);
        return CrudUtil.execute(sql, item.getQty(), item.getItemcode());
    }

    @Override
    public boolean updateQty1(Item item) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET Qty = Qty + ? WHERE Itemcode = ?";
        return (Boolean)CrudUtil.execute(sql,item.getQty(), item.getItemcode());
    }

    @Override
    public boolean updateQty1(ArrayList<SupCartDetails> supCartDetails) throws SQLException, ClassNotFoundException {
        for(SupCartDetails supCartDetails1:supCartDetails) {
            if (!updateQty1(new Item(supCartDetails1.getItemcode(), supCartDetails1.getItemcode(), supCartDetails1.getQty(), supCartDetails1.getUnitprice()))) {
                return false;
            }
        }
      /*  Iterator var1 = supCartDetails.iterator();

        SupCartDetails supCartDetails1;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            supCartDetails1 = (SupCartDetails) var1.next();
        } while(updateQty1(new Item(supCartDetails1.getS_orderId(),supCartDetails1.getItemcode(), supCartDetails1.getQty(), supCartDetails1.getUnitprice())));*/

        return true;
    }
}
