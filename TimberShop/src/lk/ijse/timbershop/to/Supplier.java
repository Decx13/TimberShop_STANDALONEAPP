package lk.ijse.timbershop.to;

public class Supplier {
    private String SupplierId;
    private String Name;
    private  String Address;
    private  String Number;

    public Supplier() {
    }

    public Supplier(String supplierId, String name, String address, String number) {
        SupplierId = supplierId;
        Name = name;
        Address = address;
        Number = number;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
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
        return "Supplier{" +
                "SupplierId='" + SupplierId + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }
}
