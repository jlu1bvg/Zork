package zork.commands;

import zork.Room;

public class go {
    public static Room runCommand(String direction, Room currentRoom) {
        if (direction == null || direction.isEmpty()) {
            System.out.println("Go where?");
            return currentRoom;
        }

        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null) {
            System.out.println("There is no exit in that direction!");
            return currentRoom;
        }

        return nextRoom;
    }
}
