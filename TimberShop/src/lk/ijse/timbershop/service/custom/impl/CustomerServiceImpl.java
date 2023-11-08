package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.CustomerDAO;
import lk.ijse.timbershop.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.timbershop.service.custom.CustomerService;
import lk.ijse.timbershop.to.Customer;

import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO = DaoFactory.getInstance().getDao(DaoType.CUSTOMER);

    @Override
    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDAO.add(customer);
    }

    @Override
    public Customer search(String CustomerId) throws SQLException, ClassNotFoundException {
        return customerDAO.search(CustomerId);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customer);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
}
