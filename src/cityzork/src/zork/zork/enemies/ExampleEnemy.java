package cityzork.src.zork.zork.enemies;


import cityzork.src.zork.zork.entites.Enemy;
import cityzork.src.zork.zork.items.Weapon;
import cityzork.src.zork.datatypes.Location;
import cityzork.src.zork.zork.Effect;
import cityzork.src.zork.zork.Inventory;
import cityzork.src.zork.zork.Room;
import cityzork.src.zork.zork.Constants.EntityConstants;

public class ExampleEnemy extends Enemy {


    public ExampleEnemy(Location location, Room currentRoom, int health, Inventory inventory, int money, int speed, String name, int exp){
        super(location, currentRoom, health, inventory, money, name, exp);
        
        // Location notRealLocation = new Location(2, 3);
        // setLocation(notRealLocation);
        // Room notRealRoom = new Room();
        // setCurrentRoom(notRealRoom);
     
        Weapon glove = new Weapon( 10, "dirty gloves", false, 2, new Effect("Poison", 2, 4, 1, 0));
        Inventory i = new Inventory(EntityConstants.MAX_INVENTORY_WEIGHT);
        i.addItem(glove);
        setInventory(i);
        setMoney(2.50);
        setSpeed(8);

    }
}
