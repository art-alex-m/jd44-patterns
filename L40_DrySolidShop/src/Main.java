import command.CommandChain;
import command.CommandParser;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Магазин");
        System.out.println("Для просмотра доступных команд введите /help");

        DependencyFabric fabric = new DependencyFabric();
        CommandParser parser = fabric.getCommandParser();
        CommandChain commands = fabric.getCommandChain();
        commands.execute(parser.parse("/help"));
    }
}