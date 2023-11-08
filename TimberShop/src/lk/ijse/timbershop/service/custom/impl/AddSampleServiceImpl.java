package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.FurnitureDAO;
import lk.ijse.timbershop.dao.custom.impl.FurnitureDAOImpl;
import lk.ijse.timbershop.service.custom.AddSampleService;
import lk.ijse.timbershop.to.Furniture;

import java.sql.SQLException;

public class AddSampleServiceImpl implements AddSampleService {
    FurnitureDAO furnitureDAO=DaoFactory.getInstance().getDao(DaoType.FURNITURE);

    @Override
    public boolean add(Furniture furniture) throws SQLException, ClassNotFoundException {
        return furnitureDAO.add(furniture);
    }

    @Override
    public Furniture search(String FurnitureId) throws SQLException, ClassNotFoundException {
        return furnitureDAO.search(FurnitureId);
    }

    @Override
    public boolean updateFurniture(Furniture furniture) throws SQLException, ClassNotFoundException {
        return furnitureDAO.update(furniture);
    }

    @Override
    public boolean deleteFurniture(String id) throws SQLException, ClassNotFoundException {
        return furnitureDAO.delete(id);
    }
}
