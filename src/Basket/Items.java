package Basket;

public class Items {
    private String item;
    private double price;

    public Items(String item, double price) {
        this.item = item;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
