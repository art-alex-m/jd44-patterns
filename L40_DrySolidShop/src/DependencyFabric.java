import command.CommandChain;
import command.CommandParser;
import command.HelpCommand;
import command.UnknownCommand;
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
                    .setNext(new UnknownCommand());
        }

        return commands;
    }

    public ProductStorage getProductStorage() {
        if (productStorage == null) {
            productStorage = new ProductStorageMapImpl();
        }

        return productStorage;
    }
}
