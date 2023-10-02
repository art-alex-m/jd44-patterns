package command;

import basket.Basket;
import product.Product;
import product.ProductStorage;

import java.util.List;

public class BasketAddCommand extends AbstractCommand {
    public static final int PRODUCT_ID_INDEX = 1;
    public static final int PRODUCT_COUNT_INDEX = 2;

    private final ProductStorage productStorage;
    private final Basket basket;

    public BasketAddCommand(ProductStorage productStorage, Basket basket) {
        super(
                new Command(List.of("/basket-add", "<product id>", "<product count>")),
                "Добавить товар в корзину: идентификатор товара, количество товара");
        this.productStorage = productStorage;
        this.basket = basket;
    }

    @Override
    protected boolean doWork(Command command) {
        if (command.getOperands().size() != getSignature().getOperands().size()) {
            throw new IllegalArgumentException("Недостаточно данных");
        }
        List<String> arguments = command.getOperands();
        int productId = Integer.parseInt(arguments.get(PRODUCT_ID_INDEX));
        int count = Integer.parseInt(arguments.get(PRODUCT_COUNT_INDEX));

        if (count <= 0) {
            throw new IllegalArgumentException("Количество товара должно быть больше 0");
        }

        Product product = productStorage.getById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Товар не найден по идентификатору");
        }

        basket.add(product.productKey, count);

        return true;
    }
}
