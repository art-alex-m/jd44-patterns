package product;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductStorageMapImpl implements ProductStorage {
    private final Map<Integer, Product> products = new HashMap<>();
    private final Map<ProductKey, Product> productsByKey = new HashMap<>();

    @Override
    public void add(Product product) {
        products.put(product.id, product);
        productsByKey.put(product.productKey, product);
    }

    @Override
    public Product getById(int id) {
        return products.get(id);
    }

    @Override
    public Product getByKey(ProductKey productKey) {
        return productsByKey.get(productKey);
    }

    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }
}
