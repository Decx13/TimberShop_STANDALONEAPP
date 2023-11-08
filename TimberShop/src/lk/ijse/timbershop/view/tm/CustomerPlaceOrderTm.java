package lk.ijse.timbershop.view.tm;

import javafx.scene.control.Button;

public class CustomerPlaceOrderTm {
    private String CorderId;
    private String CusId;
    private String ItemCode;
    private int Qty;
    private double Price;
    private Button btnDelete;

    public CustomerPlaceOrderTm() {
    }

    public CustomerPlaceOrderTm(String corderId, String cusId, String itemCode, int qty, double price, Button btnDelete) {
        CorderId = corderId;
        CusId = cusId;
        ItemCode = itemCode;
        Qty = qty;
        Price = price;
        this.btnDelete = btnDelete;
    }

    public String getCorderId() {
        return CorderId;
    }

    public void setCorderId(String corderId) {
        CorderId = corderId;
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String cusId) {
        CusId = cusId;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
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
        return "CustomerPlaceOrderTm{" +
                "CorderId='" + CorderId + '\'' +
                ", CusId='" + CusId + '\'' +
                ", ItemCode='" + ItemCode + '\'' +
                ", Qty=" + Qty +
                ", Price=" + Price +
                ", btnDelete=" + btnDelete +
                '}';
    }
}
