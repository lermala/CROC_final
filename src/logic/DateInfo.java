package logic;

import java.util.Date;

public class DateInfo {
    private Date date;
    private int quantityOfSoldProducts;

    public DateInfo(Date date) {
        this.date = date;
    }

    public DateInfo() {
    }

    @Override
    public String toString() {
        return "DateInfo{" +
                "date=" + date +
                ", quantityOfSoldProducts=" + quantityOfSoldProducts +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantityOfSoldProducts() {
        return quantityOfSoldProducts;
    }

    public void setQuantityOfSoldProducts(int quantityOfSoldProducts) {
        this.quantityOfSoldProducts = quantityOfSoldProducts;
    }
}
