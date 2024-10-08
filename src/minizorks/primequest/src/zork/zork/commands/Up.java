package minizorks.primequest.src.zork.zork.commands;

import minizorks.primequest.src.zork.zork.Command;
import minizorks.primequest.src.zork.zork.Exit;
import minizorks.primequest.src.zork.zork.Game;

public class Up extends Command {

    public Up(String name) {
        super(name);
        addAlias("u"); // Typing u also runs this command
    }

    @Override
    public String runCommand(String... args){ // Command deals with up movement
        for(Exit e : Game.getGame().getPlayer().getCurrentRoom().getExits()) {
            try{
            if(e.getDirection().equalsIgnoreCase("u")) {
                if (!e.getAdjacentRoom().isLocked() && !e.getIsExitLocked()) { //Checks if the room is locked before moving the player
                    Game.getGame().getPlayer().changeRoom(e.getAdjacentRoom());
                    e.getAdjacentRoom().printAscii();
                    return e.getAdjacentRoom().getDescription();
                } else {
                    if(e.hasLockedDescription()){
                        return e.getLockedDescription();
                    }
                    return e.getAdjacentRoom().getLockedMessage();
                }
            }
        } catch (Exception exception) {
            return "ya done goofed";
        } 
            }
            return "There is no room above you";
        }
    }