package lk.ijse.timbershop.dao.custom;

import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.CusCartDetails;

import java.sql.SQLException;
import java.util.ArrayList;


public interface CorderDetailDAO extends CrudDAO<CusCartDetails,String> {
    boolean saveOrderDetails(ArrayList<CusCartDetails> cusCartDetails) throws SQLException, ClassNotFoundException;
}
