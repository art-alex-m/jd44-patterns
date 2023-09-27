import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinOpsTest {

    private BinOps sut;

    @BeforeEach
    void setUp() {
        sut = new BinOps();
    }

    @ParameterizedTest
    @MethodSource
    public void sum(String a, String b, String expected) {
        String result = sut.sum(a, b);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource
    public void mult(String a, String b, String expected) {
        String result = sut.mult(a, b);

        Assertions.assertEquals(expected, result);
    }

    protected Stream<Arguments> sum() {
        return Stream.of(
                Arguments.of("01", "01", "10"),
                Arguments.of("100", "10", "110"),
                Arguments.of("10", "100", "110")
        );
    }

    protected Stream<Arguments> mult() {
        return Stream.of(
                Arguments.of("01", "01", "1"),
                Arguments.of("100", "01", "100"),
                Arguments.of("11", "11", "1001")
        );
    }
}