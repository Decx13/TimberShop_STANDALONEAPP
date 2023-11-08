package lk.ijse.timbershop.dao.custom;

import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.SupCartDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SorderDetailDAO extends CrudDAO<SupCartDetails,String> {
    boolean saveOrderDetails(ArrayList<SupCartDetails> supCartDetails) throws SQLException, ClassNotFoundException;
}
