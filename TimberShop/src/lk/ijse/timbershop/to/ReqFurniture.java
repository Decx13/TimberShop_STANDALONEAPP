package lk.ijse.timbershop.to;

import java.time.LocalDate;

public class ReqFurniture {
    private String ReqId;
    private String FurnitureId;
    private  String CustomerId;
    private LocalDate Date;
    private LocalDate ReqDate;
    private  double Price;

    public ReqFurniture(String string, String resultString, String customerId, java.sql.Date date, java.sql.Date resultDate, double aDouble) {
    }

    public ReqFurniture(String reqId, String furnitureId, String customerId, LocalDate date, LocalDate reqDate, double price) {
        ReqId = reqId;
        FurnitureId = furnitureId;
        CustomerId = customerId;
        Date = date;
        ReqDate = reqDate;
        Price = price;
    }

    public String getReqId() {
        return ReqId;
    }

    public void setReqId(String reqId) {
        ReqId = reqId;
    }

    public String getFurnitureId() {
        return FurnitureId;
    }

    public void setFurnitureId(String furnitureId) {
        FurnitureId = furnitureId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public LocalDate getReqDate() {
        return ReqDate;
    }

    public void setReqDate(LocalDate reqDate) {
        ReqDate = reqDate;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "ReqFurniture{" +
                "ReqId='" + ReqId + '\'' +
                ", FurnitureId='" + FurnitureId + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", Date=" + Date +
                ", ReqDate=" + ReqDate +
                ", Price=" + Price +
                '}';
    }
}
