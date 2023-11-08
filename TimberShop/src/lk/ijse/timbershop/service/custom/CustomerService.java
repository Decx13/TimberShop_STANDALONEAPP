package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.Customer;

import java.sql.SQLException;

public interface CustomerService extends SuperService {
    boolean add(Customer customer) throws SQLException, ClassNotFoundException;
     Customer search(String CustomerId) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
}
