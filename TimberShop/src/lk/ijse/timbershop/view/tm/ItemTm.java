package lk.ijse.timbershop.view.tm;

public class ItemTm {
    private String Itemode;
    private String Name;
    private int Qty;

    public ItemTm(String itemode, String name, int qty) {
        Itemode = itemode;
        Name = name;
        Qty = qty;
    }

    public String getItemode() {
        return Itemode;
    }

    public void setItemode(String itemode) {
        Itemode = itemode;
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

    @Override
    public String toString() {
        return "ItemTm{" +
                "Itemode='" + Itemode + '\'' +
                ", Name='" + Name + '\'' +
                ", Qty=" + Qty +
                '}';
    }
}
