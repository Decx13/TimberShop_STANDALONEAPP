package lk.ijse.timbershop.view.tm;

import java.sql.Date;
import java.time.LocalDate;

public class ReqFurnitureTm {
    private String ReqId;
    private  String FurnitureId;
    private String CustomerId;
    private Date ReqDate;
    double Price;

    public ReqFurnitureTm(String reqId, String furnitureId, String customerId, Date reqDate, double price) {
        ReqId = reqId;
        FurnitureId = furnitureId;
        CustomerId = customerId;
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

    public Date getReqDate() {
        return Date.valueOf(String.valueOf(ReqDate));
    }

    public void setReqDate(LocalDate reqDate) {
        ReqDate = Date.valueOf(reqDate);
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "ReqFurnitureTm{" +
                "ReqId='" + ReqId + '\'' +
                ", FurnitureId='" + FurnitureId + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", ReqDate=" + ReqDate +
                ", Price=" + Price +
                '}';
    }
}
