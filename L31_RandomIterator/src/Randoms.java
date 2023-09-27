import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private final Random generator;
    private final int min;
    private final int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        this.generator = new Random();
    }

    public int nextInt() {
        return generator.nextInt(min, max + 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomsIterator(this);
    }
}
