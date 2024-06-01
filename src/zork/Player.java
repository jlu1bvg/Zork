package zork;
import zork.utils.progressbar;
public class Player {

    private Room currentRoom;
    private int health;
    private Inventory inventory;
    private int insanity;

    public Player (Room room, int hp, Inventory i){
        currentRoom = room;
        health = hp;
        inventory = i;
        insanity = 0;
    }

    public void increaseInsanity(int amount){
        insanity += amount;
        if (insanity >= 100) {
            insanity = 100;
            System.out.println("You hear ringing in your ears...");
        }
    }
    
    public void checkInsanity(){
        String progressBar = progressbar.generateProgressBar(insanity, 100, 30);
        System.out.println("Current insanity level: " + progressBar);
        if (insanity >= 100) {
            System.out.println("You have gone insane!");
        }
    }
}
