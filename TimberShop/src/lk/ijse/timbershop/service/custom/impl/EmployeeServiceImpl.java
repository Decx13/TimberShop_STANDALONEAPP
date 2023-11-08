package lk.ijse.timbershop.service.custom.impl;

import lk.ijse.timbershop.dao.Util.DaoFactory;
import lk.ijse.timbershop.dao.Util.DaoType;
import lk.ijse.timbershop.dao.custom.EmployeeDAO;
import lk.ijse.timbershop.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.timbershop.service.custom.EmployeeService;
import lk.ijse.timbershop.to.Employee;

import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAO employeeDAO= DaoFactory.getInstance().getDao(DaoType.EMPLOYEE);

    @Override
    public boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.add(employee);
    }

    @Override
    public Employee search(String EmployeeId) throws SQLException, ClassNotFoundException {
        return employeeDAO.search(EmployeeId);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(employee);
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }
}
