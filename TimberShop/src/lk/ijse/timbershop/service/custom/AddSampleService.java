package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.Furniture;

import java.sql.SQLException;

public interface AddSampleService extends SuperService {
    boolean add(Furniture furniture) throws SQLException, ClassNotFoundException;
    Furniture search(String FurnitureId) throws SQLException, ClassNotFoundException;
    boolean updateFurniture(Furniture furniture) throws SQLException, ClassNotFoundException;
    boolean deleteFurniture(String id) throws SQLException, ClassNotFoundException;
}
