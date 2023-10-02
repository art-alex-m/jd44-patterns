package command;

import basket.Basket;
import basket.BasketToStringFormatter;

import java.io.PrintStream;
import java.util.List;

public class BasketListCommand extends AbstractCommand {

    private final BasketToStringFormatter basketToStringFormatter;
    private final Basket basket;
    private final PrintStream out;

    public BasketListCommand(BasketToStringFormatter basketToStringFormatter, Basket basket, PrintStream out) {
        super(new Command(List.of("/basket")), "Просмотр товаров в корзине");
        this.basketToStringFormatter = basketToStringFormatter;
        this.basket = basket;
        this.out = out;
    }

    @Override
    protected boolean doWork(Command command) {

        out.println(basketToStringFormatter.format(basket));

        return true;
    }
}
