package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.CustomerOrderPlace;

import java.sql.SQLException;

public interface CustomerOrderPlaceService extends SuperService {
    boolean CustomerPlaceOrder(CustomerOrderPlace customerOrderPlace) throws SQLException, ClassNotFoundException;
}
