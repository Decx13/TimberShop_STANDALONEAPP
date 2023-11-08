package lk.ijse.timbershop.to;

import java.time.LocalDate;
import java.util.ArrayList;

public class SupplierOrderPlace {
    private String S_orderId;
    private String SupplierId;
    private LocalDate Date;
    private ArrayList<SupCartDetails> orderDetails1;

    public SupplierOrderPlace() {
    }
    public SupplierOrderPlace(String s_orderId, String supplierId, ArrayList<SupCartDetails> supCartDetails) {
        this.S_orderId=s_orderId;
        this.SupplierId=supplierId;
        this.orderDetails1=supCartDetails;
    }

    public SupplierOrderPlace(String s_orderId, String supplierId, LocalDate date, ArrayList<SupCartDetails> orderDetails1) {
        S_orderId = s_orderId;
        SupplierId = supplierId;
        Date = date;
        this.orderDetails1 = orderDetails1;
    }

    public String getS_orderId() {
        return S_orderId;
    }

    public void setS_orderId(String s_orderId) {
        S_orderId = s_orderId;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public ArrayList<SupCartDetails> getOrderDetails1() {
        return orderDetails1;
    }

    public void setOrderDetails1(ArrayList<SupCartDetails> orderDetails1) {
        this.orderDetails1 = orderDetails1;
    }

    @Override
    public String toString() {
        return "SupplierOrderPlace{" +
                "S_orderId='" + S_orderId + '\'' +
                ", SupplierId='" + SupplierId + '\'' +
                ", Date=" + Date +
                ", orderDetails1=" + orderDetails1 +
                '}';
    }
}
