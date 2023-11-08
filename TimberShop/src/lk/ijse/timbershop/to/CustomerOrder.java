package lk.ijse.timbershop.to;

import java.time.LocalDate;

public class CustomerOrder {
    private String CorderId;
    private LocalDate Date;
    private String CustomerId;

    public CustomerOrder() {
    }

    public CustomerOrder(String corderId, LocalDate date, String customerId) {
        CorderId = corderId;
        Date = date;
        CustomerId = customerId;
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

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "CorderId='" + CorderId + '\'' +
                ", Date=" + Date +
                ", CustomerId='" + CustomerId + '\'' +
                '}';
    }
}
