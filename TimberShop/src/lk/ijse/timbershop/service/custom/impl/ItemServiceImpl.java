package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.ItemDAO;
import lk.ijse.timbershop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.timbershop.service.custom.ItemService;
import lk.ijse.timbershop.to.Item;

import java.sql.SQLException;

public class ItemServiceImpl implements ItemService {
    ItemDAO itemDAO= DaoFactory.getInstance().getDao(DaoType.ITEM);

    @Override
    public boolean add(Item item) throws SQLException, ClassNotFoundException {
        return itemDAO.add(item);
    }

    @Override
    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException {
        return itemDAO.update(item);
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    @Override
    public Item search(String ItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.search(ItemCode);
    }
}
