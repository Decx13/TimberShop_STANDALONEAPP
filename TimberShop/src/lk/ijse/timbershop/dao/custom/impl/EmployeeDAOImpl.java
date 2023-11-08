package lk.ijse.timbershop.dao.custom.impl;

import lk.ijse.timbershop.dao.custom.EmployeeDAO;
import lk.ijse.timbershop.db.DBConnection;
import lk.ijse.timbershop.to.Employee;
import lk.ijse.timbershop.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = " INSERT INTO Employee VALUES(?,?,?,?,?)";
        return (boolean) CrudUtil.execute(sql,new Object[]{employee.getEmployeeId(),employee.getName(),employee.getAddress(),employee.getNumber(),employee.getSalary()});

    }

    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        return (boolean) CrudUtil.execute("UPDATE Employee SET Name=?,Address=?,Number=?,Salary=? WHERE EmployeeId=?",employee.getName(),employee.getAddress(),employee.getNumber(),employee.getSalary(),employee.getEmployeeId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM Employee WHERE EmployeeId='"+id+"'")>0;
    }

    @Override
    public Employee search(String EmployeeId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Employee WHERE EmployeeID=?";
        ResultSet result = (ResultSet) CrudUtil.execute(sql, new Object[]{EmployeeId});
        return result.next() ? new Employee(result.getString(1), result.getString(2), result.getString(3), result.getString(4),result.getDouble(5)) : null;


    }

    @Override
    public ArrayList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT EmployeeId FROM Employee";
        ResultSet result = (ResultSet)CrudUtil.execute(sql, new Object[0]);
        ArrayList<String> idList = new ArrayList();

        while(result.next()) {
            idList.add(result.getString(1));
        }

        return idList;
    }
}
