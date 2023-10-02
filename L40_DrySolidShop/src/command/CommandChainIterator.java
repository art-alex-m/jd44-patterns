package command;

import java.util.Iterator;

public class CommandChainIterator implements Iterator<CommandChain> {
    protected CommandChain current;

    public CommandChainIterator(CommandChain head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public CommandChain next() {
        CommandChain commandChain = current;
        current = commandChain.getNext();

        return commandChain;
    }
}
