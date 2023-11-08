package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.ReqFurniture;

import java.sql.SQLException;

public interface ReqFurnitureService extends SuperService {
    boolean add(ReqFurniture reqFurniture) throws SQLException, ClassNotFoundException;
    ReqFurniture search(String ReqId) throws SQLException, ClassNotFoundException;
    boolean updateRequest(ReqFurniture reqFurniture) throws SQLException, ClassNotFoundException;
    boolean deleteRequest(String id) throws SQLException, ClassNotFoundException;
}
