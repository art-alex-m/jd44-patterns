package command;

import java.io.PrintStream;
import java.util.List;

public class ExitCommand extends AbstractCommand {
    private final PrintStream out;

    public ExitCommand(PrintStream out) {
        super(new Command(List.of("/exit")), "Завершить программу");
        this.out = out;
    }

    @Override
    protected boolean doWork(Command command) {
        out.println("Программа завершена");
        throw new ProgramExitException();
    }
}
