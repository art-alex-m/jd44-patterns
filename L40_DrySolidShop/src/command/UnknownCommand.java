package command;

public class UnknownCommand extends AbstractCommand {
    public UnknownCommand() {
        super(new Command(), "Если команда не была обработана");
    }

    @Override
    protected boolean doWork(Command command) {
        throw new IllegalCallerException(String.format("Неизвестная команда '%s'", command));
    }

    @Override
    protected boolean commandNotMatch(Command command) {
        return false;
    }
}
