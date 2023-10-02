package basket;

import product.ProductKey;

public interface Basket extends Totalable, Iterable<BasketItem> {
    void add(ProductKey productKey, int count);

    boolean isEmpty();
}
