package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.UserDAO;
import lk.ijse.timbershop.dao.custom.impl.UserDAOImpl;
import lk.ijse.timbershop.service.custom.LoginFormService;
import lk.ijse.timbershop.to.User;

import java.sql.SQLException;

public class LoginFormServiceImpl implements LoginFormService {
    UserDAO userDAO= DaoFactory.getInstance().getDao(DaoType.USER);

    @Override
    public boolean signUp(User user) throws SQLException, ClassNotFoundException {
        return userDAO.add(user);
    }
}
