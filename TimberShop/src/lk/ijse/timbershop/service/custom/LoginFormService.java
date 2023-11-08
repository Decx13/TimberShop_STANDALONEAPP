package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.User;

import java.sql.SQLException;

public interface LoginFormService extends SuperService {
    boolean signUp(User user) throws SQLException, ClassNotFoundException;
}
