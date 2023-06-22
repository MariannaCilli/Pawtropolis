package command;

import model.Direction;
import controller.GameController;
import model.Room;

public class GoCommand implements GameCommand {

    private GameController gameController;
    private String direction;

    public GoCommand(GameController gameController, String direction) {
        this.gameController = gameController;
        this.direction= direction;
    }

    @Override
    public void execute() {

        Direction direction;
        switch (this.direction) {
            case "north":
                direction = Direction.NORTH;
                break;
            case "south":
                direction = Direction.SOUTH;
                break;
            case "east":
                direction = Direction.EAST;
                break;
            case "west":
                direction = Direction.WEST;
                break;
            default:
                System.out.println("\nInvalid direction. Choose a valid direction: north, south, east, west");
                return;
        }

        Room currentRoom = gameController.getMapController().getCurrentRoom();
        Room newRoom = currentRoom.getAdjoiningDirectionRoom(Direction.getDirectionFromString(direction.getDirectionString()));
        if (newRoom != null) {
            gameController.getMapController().setCurrentRoom(newRoom);
            System.out.println("\nYou have entered " + newRoom.getName());

            LookCommand lookCommand = new LookCommand(gameController);
            lookCommand.execute();
        } else {
            System.out.println("\nThere is no room in that direction");
        }
    }


}