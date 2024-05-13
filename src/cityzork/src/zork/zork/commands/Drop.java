package cityzork.src.zork.zork.commands;

import cityzork.src.zork.zork.Command;
import cityzork.src.zork.zork.Game;
import cityzork.src.zork.zork.Item;
import cityzork.src.zork.zork.entites.Player;

public class Drop extends Command {

    public Drop(String name) {
        super(name);
    }

    @Override
    public String runCommand(String... args) { // Command that handles dropping items
        Game game = Game.getGame();
        for(int i = 0; i < game.getPlayer().getInventory().getItemCount(); i++) {
            cityzork.src.zork.zork.Inventory inventory = game.getPlayer().getInventory();
            Player player = game.getPlayer();
            String command = "";
            for (int j = 0; j < args.length; j++) {
                command+=args[j] + " ";
            }
            command = command.substring(0, command.length()-1);
            if(command.contains("fists")){ // Stops the player from dropping fists
                return "what? you know you cant take those off right?";
            } else if(command.contains("prime")) { // Stops the player from dropping prime
                return "You try to drop the prime, but it still shows up in for inventory";
            }
            if(command != null && inventory.getItem(i) != null) { // Line 30 - 40 handles removing item from inventory, changing weight and adding to the rooms inventory
                if (command.contains(inventory.getItem(i).getName().toLowerCase())) { 
                    int weight = inventory.getCurrentWeight();
                    weight = weight - inventory.getItem(i).getWeight();
                    player.getInventory().setCurrentWeight(weight);
                    Item item = inventory.getItem(i);
                    String getItemName = inventory.getItem(i).getName();
                    game.getPlayer().getInventory().removeItem(Game.getGame().getPlayer().getInventory().getItem(i));
                    player.getCurrentRoom().addItemGround(item);

                    return "You dropped your " + getItemName + " on the ground"; 
                }
            }
        }
        return "You do not have that in your inventory";
        


    }
}
