package product;

public class Product {
    public final int id;
    public final String title;
    public final int price;
    public final Unit unit;

    public final ProductKey productKey;

    public Product(int id, String title, int price, Unit unit) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.unit = unit;
        this.productKey = new ProductKey(id, price);
    }

    public Product(int id, String title, int price) {
        this(id, title, price, Unit.PIECES);
    }
}
