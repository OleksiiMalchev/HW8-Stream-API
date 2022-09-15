import java.time.LocalDate;

public class Product {
    private long ID;
    private String type;
    private double price;
    private boolean isDiscount;
    private LocalDate date;

    public Product(long ID, String type, double price, boolean isDiscount, LocalDate date) {
        this.ID = ID;
        this.type = type;
        this.price = price;
        this.isDiscount = isDiscount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", isDiscount=" + isDiscount +
                ", date=" + date +
                '}' +
                "\n";
    }
}