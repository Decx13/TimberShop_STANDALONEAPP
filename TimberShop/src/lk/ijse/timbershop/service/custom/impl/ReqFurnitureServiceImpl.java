package lk.ijse.timbershop.service.custom.impl;


import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.ReqFurnitureDAO;
import lk.ijse.timbershop.dao.custom.impl.ReqFurnitureDAOImpl;
import lk.ijse.timbershop.service.custom.ReqFurnitureService;
import lk.ijse.timbershop.to.ReqFurniture;

import java.sql.SQLException;

public class ReqFurnitureServiceImpl implements ReqFurnitureService {
    ReqFurnitureDAO reqFurnitureDAO= DaoFactory.getInstance().getDao(DaoType.REQFURNITURE);

    @Override
    public boolean add(ReqFurniture reqFurniture) throws SQLException, ClassNotFoundException {
        return reqFurnitureDAO.add(reqFurniture);
    }

    @Override
    public ReqFurniture search(String ReqId) throws SQLException, ClassNotFoundException {
        return reqFurnitureDAO.search(ReqId);
    }

    @Override
    public boolean updateRequest(ReqFurniture reqFurniture) throws SQLException, ClassNotFoundException {
        return reqFurnitureDAO.update(reqFurniture);
    }

    @Override
    public boolean deleteRequest(String id) throws SQLException, ClassNotFoundException {
        return reqFurnitureDAO.delete(id);
    }
}
