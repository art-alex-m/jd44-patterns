import command.*;
import product.ProductGenerator;
import product.ProductListFormatter;
import product.ProductStorage;
import product.ProductStorageMapImpl;

public class DependencyFabric {
    private final CommandParser commandParser = new CommandParser();
    private final ProductListFormatter productListFormatter = new ProductListFormatter();

    private ProductStorage productStorage;
    private CommandChain commands;

    public CommandParser getCommandParser() {
        return commandParser;
    }

    public ProductListFormatter getProductListFormatter() {
        return productListFormatter;
    }

    public CommandChain getCommandChain() {
        if (commands == null) {
            commands = new HelpCommand(System.out);
            commands
                    .setNext(new ProductListCommand(getProductStorage(), getProductListFormatter(), System.out))
                    .setNext(new UnknownCommand());
        }

        return commands;
    }

    public ProductStorage getProductStorage() {
        if (productStorage == null) {
            ProductGenerator productGenerator = new ProductGenerator();
            productStorage = new ProductStorageMapImpl();
            int limit = ProductGenerator.DEFAULT_STORAGE_CAPACITY;
            while (--limit >= 0) {
                productStorage.add(productGenerator.generate());
            }
        }

        return productStorage;
    }
}
