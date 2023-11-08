package lk.ijse.timbershop.dao.custom;

import lk.ijse.timbershop.dao.CrudDAO;
import lk.ijse.timbershop.to.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee,String> {
    ArrayList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException;
}
