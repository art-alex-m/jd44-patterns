package product;

import java.util.Objects;

public class ProductKey {
    public final int productId;
    public final int price;

    public ProductKey(int productId, int price) {
        this.productId = productId;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductKey that = (ProductKey) o;
        return productId == that.productId && price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price);
    }
}
