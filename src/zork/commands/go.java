package zork.commands;

import zork.Command;
import zork.Room;

public class go {
    public static Room goRoom(Room currentRoom, Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return currentRoom;
        }
        String direction = Command.getSecondWord();
        return goRoom(currentRoom, direction);
    }

    public static Room goRoom(Room currentRoom, String direction) {
        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
            return currentRoom;
        } else {
            System.out.println(nextRoom.longDescription());
            return nextRoom;
        }
    }
}
