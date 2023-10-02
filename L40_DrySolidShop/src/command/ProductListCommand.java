package command;

import product.ProductListFormatter;
import product.ProductStorage;

import java.io.PrintStream;
import java.util.List;

public class ProductListCommand extends AbstractCommand {
    private final ProductStorage productStorage;
    private final ProductListFormatter formatter;
    private final PrintStream out;

    public ProductListCommand(ProductStorage productStorage, ProductListFormatter formatter, PrintStream out) {
        super(new Command(List.of("/product-list")), "Просмотр списка доступных товаров");
        this.productStorage = productStorage;
        this.formatter = formatter;
        this.out = out;
    }

    @Override
    protected boolean doWork(Command command) {
        out.println(formatter.format(productStorage));

        return true;
    }
}
