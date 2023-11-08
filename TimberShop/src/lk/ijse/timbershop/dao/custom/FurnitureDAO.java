package lk.ijse.timbershop.dao.custom;

import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.Furniture;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FurnitureDAO extends CrudDAO<Furniture,String> {
    ArrayList<String> loadFurnitureIds() throws SQLException, ClassNotFoundException;
}
