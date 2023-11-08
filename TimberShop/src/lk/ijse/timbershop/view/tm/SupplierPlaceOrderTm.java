package lk.ijse.timbershop.view.tm;

import javafx.scene.control.Button;

public class SupplierPlaceOrderTm {
    private String SorderId;
    private String SuppllierId;
    private String Itemcode;
    private int Qty;
    private double Price;
    private Button btnDelete;

    public SupplierPlaceOrderTm() {
    }

    public SupplierPlaceOrderTm(String sorderId, String suppllierId, String itemcode, int qty, double price, Button btnDelete) {
        SorderId = sorderId;
        SuppllierId = suppllierId;
        Itemcode = itemcode;
        Qty = qty;
        Price = price;
        this.btnDelete = btnDelete;
    }

    public String getSorderId() {
        return SorderId;
    }

    public void setSorderId(String sorderId) {
        SorderId = sorderId;
    }

    public String getSuppllierId() {
        return SuppllierId;
    }

    public void setSuppllierId(String suppllierId) {
        SuppllierId = suppllierId;
    }

    public String getItemcode() {
        return Itemcode;
    }

    public void setItemcode(String itemcode) {
        Itemcode = itemcode;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "SupplierPlaceOrderTm{" +
                "SorderId='" + SorderId + '\'' +
                ", SuppllierId='" + SuppllierId + '\'' +
                ", Itemcode='" + Itemcode + '\'' +
                ", Qty=" + Qty +
                ", Price=" + Price +
                ", btnDelete=" + btnDelete +
                '}';
    }
}
