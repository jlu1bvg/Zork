package zork.commands;

import zork.Room;
import zork.Command;
public class go {
    public static void goRoom(Room currentRoom, Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null)
            System.out.println("There is no door!");
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.longDescription());
        }
    }
}
