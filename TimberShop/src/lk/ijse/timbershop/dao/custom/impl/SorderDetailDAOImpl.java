package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.SorderDetailDAO;
import lk.ijse.timbershop.to.SupCartDetails;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class SorderDetailDAOImpl implements SorderDetailDAO {
    @Override
    public boolean add(SupCartDetails supCartDetails) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO S_orderDetail VALUES(?, ?, ?, ?)";
        return (Boolean) CrudUtil.execute(sql, new Object[]{supCartDetails.getS_orderId(), supCartDetails.getItemcode(), supCartDetails.getQty(), supCartDetails.getUnitprice()});

    }

    @Override
    public boolean update(SupCartDetails obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean delete(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");
    }

    @Override
    public SupCartDetails search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");
    }

    @Override
    public boolean saveOrderDetails(ArrayList<SupCartDetails> supCartDetails) throws SQLException, ClassNotFoundException {
        Iterator var1 = supCartDetails.iterator();

        SupCartDetails cartDetail;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            cartDetail = (SupCartDetails) var1.next();
        } while(add(cartDetail));

        return false;
    }
}
