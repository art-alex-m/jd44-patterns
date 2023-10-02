import command.Command;
import command.CommandChain;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DependencyFabric fabric = new DependencyFabric();
        CommandChain commands = fabric.getCommandChain();
        commands.execute(new Command(List.of("/help")));
    }
}