package lk.ijse.timbershop.to;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerOrderPlace {
    private  String CorderId;
    private LocalDate Date;
    private String CustomerId;
    private ArrayList<CusCartDetails> OrderDetails=new ArrayList();

    public CustomerOrderPlace(String CorderId, String customerId, ArrayList<CusCartDetails> cusCartDetails) {
        this.CorderId=CorderId;
        this.CustomerId = customerId;
        this.OrderDetails = cusCartDetails;
    }

    public CustomerOrderPlace(String corderId, LocalDate date, String customerId, ArrayList<CusCartDetails> orderDetails) {
        CorderId = corderId;
        Date = date;
        CustomerId = customerId;
        OrderDetails = orderDetails;
    }

    public String getCorderId() {
        return CorderId;
    }

    public void setCorderId(String corderId) {
        CorderId = corderId;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public ArrayList<CusCartDetails> getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetails(ArrayList<CusCartDetails> orderDetails) {
        OrderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "CustomerOrderPlace{" +
                "CorderId='" + CorderId + '\'' +
                ", Date=" + Date +
                ", CustomerId='" + CustomerId + '\'' +
                ", OrderDetails=" + OrderDetails +
                '}';
    }
}
