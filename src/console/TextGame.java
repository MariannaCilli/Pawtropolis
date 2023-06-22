package console;

import command.*;
import controller.GameController;
import controller.InputController;
import controller.MapController;
import model.*;


public class TextGame {

    private GameController gameController;


    boolean gameRunning = true;



    public TextGame() {


        System.out.println("Welcome to Pawtropolis!");
        System.out.print("Enter your player name: ");
        String playerName = InputController.readString();
        gameController = new GameController(new Player(playerName, Player.MAX_LIFE_POINTS, new Bag()), new MapController());
    }

    public void start() {
        System.out.println("\nHello " + gameController.getPlayer().getName() + "! Please enter 'help' if you would like to view the available commands");

        while (gameRunning) {
            System.out.print("\n> ");
            String input = InputController.readString();
            String cleanedInputSingleWord = InputController.cleanerInputSingleWord(input);
            String cleanedMultipleWords = InputController.cleanerInputMultipleWord(input);

            if (InputController.equalsIgnoreCase(cleanedInputSingleWord, "help")) {
                HelpCommand helpCommand = new HelpCommand();
                helpCommand.execute();
            } else if (InputController.equalsIgnoreCase(cleanedInputSingleWord, "look")) {
                LookCommand lookCommand = new LookCommand(gameController);
                lookCommand.execute();
            } else if  (cleanedMultipleWords.startsWith("go")) {
                String[] commandParts = cleanedMultipleWords.split("\\s+", 2);
                if (commandParts.length != 2) {
                    System.out.println("\nInvalid command. Please use the format: go [direction]");
                    continue;
                }
                String direction = commandParts[1];
                GameCommand goCommand = new GoCommand(gameController, direction);
                goCommand.execute();
            } else if (cleanedMultipleWords.startsWith("get")) {
                String[] commandParts = cleanedMultipleWords.split("\\s+", 2);
                if (commandParts.length != 2) {
                    System.out.println("\nInvalid command. Please use the format: get [item name]");
                    continue;
                }
                String itemName = commandParts[1];
                GameCommand addCommand = new AddCommand(gameController, itemName);
                addCommand.execute();
            } else if (cleanedMultipleWords.startsWith("drop")) {
                String[] commandParts = cleanedMultipleWords.split("\\s+", 2);
                if (commandParts.length != 2) {
                    System.out.println("\nInvalid command. Please use the format: get [item name]");
                    continue;
                }
                String itemName = commandParts[1];
                DropCommand dropCommand = new DropCommand(gameController, itemName);
                dropCommand.execute();
            } else if (InputController.equalsIgnoreCase(cleanedInputSingleWord, "showBag")) {
                ShowBagCommand showBagCommand = new ShowBagCommand(gameController);
                showBagCommand.execute();
            } else if (InputController.equalsIgnoreCase(cleanedInputSingleWord, "quit")) {
                QuitCommand quitCommand = new QuitCommand();
                quitCommand.execute();
                setGameRunning(false);
            } else {
                System.out.println("\nInvalid command. Enter 'help' to view the available commands.");
            }
        }
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public static void main(String[] args) {
        TextGame game = new TextGame();
        game.start();
    }
}
