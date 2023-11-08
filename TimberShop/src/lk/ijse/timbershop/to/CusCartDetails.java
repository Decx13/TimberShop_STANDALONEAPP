package lk.ijse.timbershop.to;

public class CusCartDetails {
    private String CorderId;
    private String Itemcode;
    private int Qty;
    private double Unitprice;

    public CusCartDetails(String corderId, String cusId, String itemCode, int qty, double price) {
        CorderId = corderId;
        Itemcode = itemCode;
        Qty = qty;
        Unitprice = price;
    }

    public CusCartDetails(String corderId, String itemcode, int qty, double unitprice) {
        CorderId = corderId;
        Itemcode = itemcode;
        Qty = qty;
        Unitprice = unitprice;
    }

    public String getCorderId() {
        return CorderId;
    }

    public void setCorderId(String corderId) {
        CorderId = corderId;
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
        return "CusCartDetails{" +
                "CorderId='" + CorderId + '\'' +
                ", Itemcode='" + Itemcode + '\'' +
                ", Qty=" + Qty +
                ", Unitprice=" + Unitprice +
                '}';
    }
}
