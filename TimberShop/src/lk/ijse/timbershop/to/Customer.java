package lk.ijse.timbershop.to;

public class Customer {
    private String CustomerId;
    private String Name;
    private String Address;
    private String Number;

    public Customer(String employeeId, String name, String address, String number, double salary) {
    }

    public Customer(String customerId, String name, String address, String number) {
        CustomerId = customerId;
        Name = name;
        Address = address;
        Number = number;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
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

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId='" + CustomerId + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }
}
