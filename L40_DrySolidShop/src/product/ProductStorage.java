package product;

public interface ProductStorage extends Iterable<Product> {
    void add(Product product);

    Product getById(int id);

    Product getByKey(ProductKey productKey);
}
