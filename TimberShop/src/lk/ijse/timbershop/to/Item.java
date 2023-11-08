package lk.ijse.timbershop.to;

public class Item {
    private  String Itemcode;
    private  String Name;
    private  int Qty;
    private  double Unitprice;

    public Item() {
    }

    public Item(String itemcode, String name, int qty, double unitprice) {
        Itemcode = itemcode;
        Name = name;
        Qty = qty;
        Unitprice = unitprice;
    }

    public String getItemcode() {
        return Itemcode;
    }

    public void setItemcode(String itemcode) {
        Itemcode = itemcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
        return "Item{" +
                "Itemcode='" + Itemcode + '\'' +
                ", Name='" + Name + '\'' +
                ", Qty=" + Qty +
                ", Unitprice=" + Unitprice +
                '}';
    }
}
