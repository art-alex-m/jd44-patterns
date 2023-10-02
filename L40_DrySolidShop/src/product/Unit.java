package product;

public enum Unit {
    PIECES("шт"),
    KG("кг"),
    LITERS("л");

    public final String name;

    Unit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
