package lk.ijse.timbershop.to;

public class SupCartDetails {
    private String S_orderId;
    private String Itemcode;
    private int Qty;
    private double Unitprice;

    public SupCartDetails(String s_orderId, String supplierId, String itemcode, int qty, double price) {
        S_orderId = s_orderId;
        Itemcode = itemcode;
        Qty = qty;
        Unitprice =price;
    }

    public SupCartDetails(String s_orderId, String itemcode, int qty, double unitprice) {
        S_orderId = s_orderId;
        Itemcode = itemcode;
        Qty = qty;
        Unitprice = unitprice;
    }

    public String getS_orderId() {
        return S_orderId;
    }

    public void setS_orderId(String s_orderId) {
        S_orderId = s_orderId;
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

    public double getUnitprice() {
        return Unitprice;
    }

    public void setUnitprice(double unitprice) {
        Unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "SupCartDetails{" +
                "S_orderId='" + S_orderId + '\'' +
                ", Itemcode='" + Itemcode + '\'' +
                ", Qty=" + Qty +
                ", Unitprice=" + Unitprice +
                '}';
    }
}
