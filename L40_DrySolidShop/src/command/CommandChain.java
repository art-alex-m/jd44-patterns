package command;

public interface CommandChain {
    void execute(Command command);

    Command getSignature();

    CommandChain getNext();

    String getDescription();

    CommandChain setNext(CommandChain command);

    boolean hasNext();
}
