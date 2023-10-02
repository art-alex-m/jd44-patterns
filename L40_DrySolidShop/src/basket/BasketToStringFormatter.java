package basket;

import product.Product;
import product.ProductStorage;

public class BasketToStringFormatter {
    private final ProductStorage productStorage;

    public BasketToStringFormatter(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public String format(Basket basket) {
        if (basket.isEmpty()) {
            return "Ваша корзина пока еще пуста";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Ваша корзина:\n");
        for (BasketItem basketItem : basket) {
            Product product = productStorage.getByKey(basketItem.getProductKey());
            builder.append(String.format(
                    "%2s. %s %s%s, %s руб/%s, итого %s руб%n",
                    product.id,
                    product.title,
                    basketItem.getCount(),
                    product.unit,
                    product.price,
                    product.unit,
                    basketItem.getTotal()
            ));
        }

        builder.append(String.format("Всего %s руб", basket.getTotal()));

        return builder.toString();
    }
}
