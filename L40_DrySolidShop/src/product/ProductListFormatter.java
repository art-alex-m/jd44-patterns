package product;

public class ProductListFormatter {

    public String format(final ProductStorage productStorage) {
        StringBuilder builder = new StringBuilder();
        builder.append("Список доступных продуктов:\n");
        for (Product product : productStorage) {
            builder.append(String.format(
                    "%2s. %s - %s руб/%s\n",
                    product.id,
                    product.title,
                    product.price,
                    product.unit
            ));
        }
        return builder.toString();
    }
}
