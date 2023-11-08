package lk.ijse.timbershop.service.custom;

import lk.ijse.timbershop.service.SuperService;
import lk.ijse.timbershop.to.Employee;

import java.sql.SQLException;

public interface EmployeeService extends SuperService {
    boolean add(Employee employee) throws SQLException, ClassNotFoundException;
    Employee search(String EmployeeId) throws SQLException, ClassNotFoundException;
    boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;
}
