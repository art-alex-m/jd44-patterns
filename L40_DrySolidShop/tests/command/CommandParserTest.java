package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CommandParserTest {

    @ParameterizedTest
    @MethodSource
    void parse(String text, Command expected) {
        CommandParser sut = new CommandParser();

        Command result = sut.parse(text);

        Assertions.assertEquals(expected.hashCode(), result.hashCode());
    }

    public static Stream<Arguments> parse() {
        return Stream.of(
                Arguments.of("test 1 2 3", new Command(List.of("test", "1", "2", "3"))),
                Arguments.of("test  ", new Command(List.of("test"))),
                Arguments.of("", new Command(List.of(""))),
                Arguments.of("some-test <arg1>   <arg2>", new Command(List.of("some-test", "<arg1>", "<arg2>")))
        );
    }
}