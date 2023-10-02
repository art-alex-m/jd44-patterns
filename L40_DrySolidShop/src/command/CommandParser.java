package command;

import java.util.List;

public class CommandParser {
    public Command parse(String text) {
        return new Command(List.of(text.split("\s+")));
    }
}
