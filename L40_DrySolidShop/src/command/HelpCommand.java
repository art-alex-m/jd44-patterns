package command;

import java.io.PrintStream;
import java.util.List;

public class HelpCommand extends AbstractCommand {
    private final PrintStream out;

    public HelpCommand(PrintStream out) {
        super(new Command(List.of("/help")), "Describe all available commands");
        this.out = out;
    }

    @Override
    protected boolean doWork(Command command) {

        CommandChainIterator it = new CommandChainIterator(this);
        while (it.hasNext()) {
            CommandChain executor = it.next();
            if (executor.getSignature().getStatement().isEmpty()) {
                continue;
            }
            out.printf("%s%n\t%s%n", executor.getSignature(), executor.getDescription());
        }

        return true;
    }
}
