package lk.ijse.timbershop.to;

public class Employee {
    private String EmployeeId;
    private  String Name;
    private String Address;
    private String Number;
    private double Salary;

    public Employee(String string, String resultString, String s, String string1) {
    }

    public Employee(String employeeId, String name, String address, String number, double salary) {
        EmployeeId = employeeId;
        Name = name;
        Address = address;
        Number = number;
        Salary = salary;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId='" + EmployeeId + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Number='" + Number + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
