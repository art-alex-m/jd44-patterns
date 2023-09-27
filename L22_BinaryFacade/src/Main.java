public class Main {
    public static void main(String[] args) {
        BinOps binOps = new BinOps();
        System.out.printf("%s + %s = %s%n", "01", "01", binOps.sum("01", "01"));
        System.out.printf("%s * %s = %s%n", "10", "10", binOps.mult("10", "10"));
    }
}