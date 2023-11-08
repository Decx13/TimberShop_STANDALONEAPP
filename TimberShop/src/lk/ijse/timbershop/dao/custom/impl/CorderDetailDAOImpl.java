package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.CorderDetailDAO;
import lk.ijse.timbershop.to.CusCartDetails;
import lk.ijse.timbershop.util.CrudUtil;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class CorderDetailDAOImpl implements CorderDetailDAO {

    @Override
    public boolean add(CusCartDetails cusCartDetails) throws SQLException, ClassNotFoundException {
        System.out.println(cusCartDetails.getCorderId());
        String sql = "INSERT INTO C_orderDetail VALUES(?, ?, ?, ?)";
        return (Boolean) CrudUtil.execute(sql,
                cusCartDetails.getCorderId(),
                cusCartDetails.getItemcode(),
                cusCartDetails.getQty(),
                cusCartDetails.getUnitprice());

    }

    @Override
    public boolean update(CusCartDetails obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("update function not available");
    }

    @Override
    public boolean delete(String obj) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("delete function not available");

    }

    @Override
    public CusCartDetails search(String ID) throws SQLException, ClassNotFoundException {
        throw new RuntimeException("search function not available");

    }

    @Override
    public boolean saveOrderDetails(ArrayList<CusCartDetails> cusCartDetails) throws SQLException, ClassNotFoundException {
        Iterator var1 = cusCartDetails.iterator();

        CusCartDetails cusCartDetail;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            cusCartDetail = (CusCartDetails) var1.next();
        } while(add(cusCartDetail));

        return false;
    }
}
