package lk.ijse.timbershop.to;

public class Furniture {
    private String FurnitureId;
    private String Name;
    private String Style;
    private double Price;

    public Furniture() {
    }

    public Furniture(String furnitureId, String name, String style, double price) {
        FurnitureId = furnitureId;
        Name = name;
        Style = style;
        Price = price;
    }

    public String getFurnitureId() {
        return FurnitureId;
    }

    public void setFurnitureId(String furnitureId) {
        FurnitureId = furnitureId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "FurnitureModel{" +
                "FurnitureId='" + FurnitureId + '\'' +
                ", Name='" + Name + '\'' +
                ", Style='" + Style + '\'' +
                ", Price=" + Price +
                '}';
    }
}
