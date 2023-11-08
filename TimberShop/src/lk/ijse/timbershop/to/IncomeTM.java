package lk.ijse.timbershop.to;

public class IncomeTM {
    private String date;
    private int count;
    private double total;

    public IncomeTM(String date, int count, double total) {
        this.date = date;
        this.count = count;
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
