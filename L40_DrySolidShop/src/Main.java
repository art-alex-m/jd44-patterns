import command.CommandChain;
import command.CommandParser;
import command.ProgramExitException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Магазин");
        System.out.println("Для просмотра доступных команд введите /help");

        DependencyFabric fabric = new DependencyFabric();
        CommandParser parser = fabric.getCommandParser();
        CommandChain commands = fabric.getCommandChain();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите новую команду");
            try {
                String commandText = scanner.nextLine();
                commands.execute(parser.parse(commandText));
            } catch (ProgramExitException ex) {
                break;
            } catch (IllegalArgumentException | IllegalCallerException ex) {
                System.out.println(ex.getMessage());
            }
        }

        scanner.close();
    }
}