package command;

public class UnknownCommand extends AbstractCommand {
    public UnknownCommand() {
        super(new Command(), "If command does not executed");
    }

    @Override
    protected boolean doWork(Command command) {
        throw new IllegalCallerException(String.format("Command was not executed '%s'", command));
    }

    @Override
    protected boolean commandNotMatch(Command command) {
        return false;
    }
}
