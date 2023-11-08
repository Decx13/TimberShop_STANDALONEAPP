package lk.ijse.timbershop.service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.ItemDAO;
import lk.ijse.timbershop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.timbershop.service.custom.OrderFormService;
import lk.ijse.timbershop.view.tm.ItemTm;

import java.sql.SQLException;

public class OrderFormServiceImpl implements OrderFormService {
    ItemDAO itemDAO= DaoFactory.getInstance().getDao(DaoType.ITEM);

    @Override
    public ObservableList<ItemTm> getItemDetails() throws SQLException, ClassNotFoundException {
        return itemDAO.getItemDetails();
    }
}
