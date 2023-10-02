package command;

public abstract class AbstractCommand implements CommandChain {

    private final Command signature;
    private final String description;
    private CommandChain next;

    protected AbstractCommand(Command signature, String description) {
        this.signature = signature;
        this.description = description;
    }

    protected abstract boolean doWork(Command command);

    @Override
    public void execute(Command command) {
        if ((commandNotMatch(command) || !doWork(command)) && hasNext()) {
            next.execute(command);
        }
    }

    @Override
    public CommandChain getNext() {
        return next;
    }

    @Override
    public CommandChain setNext(CommandChain next) {
        this.next = next;
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Command getSignature() {
        return signature;
    }

    @Override
    public String getDescription() {
        return description;
    }

    protected boolean commandNotMatch(Command command) {
        return !signature.getStatement().equals(command.getStatement());
    }
}
