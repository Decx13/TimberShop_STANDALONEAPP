package lk.ijse.timbershop.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.ReqFurniture;
import lk.ijse.timbershop.view.tm.ReqFurnitureTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReqFurnitureDAO extends CrudDAO<ReqFurniture,String> {
    ArrayList<String> loadReqIds() throws SQLException, ClassNotFoundException;
    ObservableList<ReqFurnitureTm> getReqetails() throws SQLException, ClassNotFoundException;
}
