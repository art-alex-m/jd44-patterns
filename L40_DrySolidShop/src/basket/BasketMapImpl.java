package basket;

import product.ProductKey;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BasketMapImpl implements Basket {

    private final Map<ProductKey, BasketItem> items = new HashMap<>();

    @Override
    public void add(ProductKey productKey, int count) {
        BasketItem item = items.getOrDefault(productKey, null);
        if (item == null) {
            item = new BasketItem(productKey);
            items.put(productKey, item);
        }
        item.addCount(count);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public Iterator<BasketItem> iterator() {
        return items.values().iterator();
    }

    @Override
    public int getTotal() {
        int total = 0;
        for (BasketItem item : this) {
            total += item.getTotal();
        }

        return total;
    }
}
