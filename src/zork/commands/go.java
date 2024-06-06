package zork.commands;

import zork.Command;
import zork.Room;

public class go {
    public static Room goRoom(Room currentRoom, Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return currentRoom;
        }
        String direction = command.getSecondWord();
        return goRoom(currentRoom, direction);
    }

    public static Room goRoom(Room currentRoom, String direction) {
        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null) {
            System.out.println("\nThere is no door!\n");
            return currentRoom;
        } else {
            System.out.println(nextRoom.longDescription());
            return nextRoom;
        }
    }
}
