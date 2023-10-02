package product;

import java.util.List;
import java.util.Random;

public class ProductGenerator {
    private static final int PRICE_START = 10;
    public static final int PRiCE_END = 1000;
    public static final int DEFAULT_STORAGE_CAPACITY = 10;

    private final List<String> titles = List.of("Молоко", "Сыр", "Конфета", "Рис", "Греча", "Масло сливочное", "Орехи", "Мука");
    private final Random random = new Random();
    private final Unit[] units = Unit.values();

    private int id = 0;

    public Product generate() {
        id++;
        int price = random.nextInt(PRICE_START, PRiCE_END);
        Unit unit = units[random.nextInt(0, units.length)];
        String title = titles.get(random.nextInt(0, titles.size())) + price;

        return new Product(id, title, price, unit);
    }
}
