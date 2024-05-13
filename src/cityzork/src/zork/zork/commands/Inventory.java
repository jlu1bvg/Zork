package cityzork.src.zork.zork.commands;


import cityzork.src.zork.zork.Command;
import cityzork.src.zork.zork.Game;
import cityzork.src.zork.zork.Item;
import cityzork.src.zork.zork.Constants.PlayerConstants;
// import cityzork.src.zork.zork.entites.Player;

public class Inventory extends Command {
    public Inventory(String name) {
        super(name);
        addAlias("i");
    }
    @Override
    public String runCommand(String... args) {
        System.out.println("Level: " + Game.getGame().getPlayer().getLevel());
        System.out.println("Health: " + Game.getGame().getPlayer().getHealth() +"/" + Game.getGame().getPlayer().getMaxHealth());
        System.out.println("Money: " + Game.getGame().getPlayer().getMoney() + "$");
        System.out.println("Your Current Weight: " + Game.getGame().getPlayer().getInventory().getCurrentWeight() + "/" + PlayerConstants.MAX_INVENTORY_WEIGHT + "Lbs");
        for (Item item : Game.getGame().getPlayer().getInventory().getItems()) {
            System.out.println("> " + item.getName());
           
        }
        
        return "";
    }    
}
