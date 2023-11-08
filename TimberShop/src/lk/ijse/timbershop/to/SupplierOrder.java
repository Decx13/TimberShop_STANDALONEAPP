package lk.ijse.timbershop.to;

import java.time.LocalDate;

public class SupplierOrder {

    private String S_orderId;
    private String SupplierId;
    private LocalDate Date;

    public SupplierOrder() {
    }

    public SupplierOrder(String s_orderId, String supplierId, LocalDate date) {
        S_orderId = s_orderId;
        SupplierId = supplierId;
        Date = date;
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

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "S_orderId='" + S_orderId + '\'' +
                ", SupplierId='" + SupplierId + '\'' +
                ", Date=" + Date +
                '}';
    }
}
