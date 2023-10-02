package basket;

import product.ProductKey;

public class BasketItem implements Totalable {

    private final ProductKey productKey;
    private int count;

    public BasketItem(ProductKey productKey) {
        this.productKey = productKey;
        this.count = 0;
    }

    public ProductKey getProductKey() {
        return productKey;
    }

    public int getCount() {
        return count;
    }

    public void addCount(int count) {
        this.count += count;
    }

    public int getPrice() {
        return productKey.price;
    }

    public int getProductId() {
        return productKey.productId;
    }

    @Override
    public int getTotal() {
        return productKey.price * count;
    }
}
