package zork;
import zork.utils.ProgressBar;
public class Player {

    private int health;
    private static Inventory inventory;
    private int insanity;

    public Player (int hp, Inventory i){
        health = hp;
        inventory = i;
        insanity = 0;
    }

    public static Inventory getInventory(){
        return inventory;
    }

    public void increaseInsanity(int amount){
        insanity += amount;
        System.out.println("You hear ringing in your ears...");
        if (insanity >= 100) {
            insanity = 100;
        }
    }
    
    public void checkInsanity(){
        String progressBar = ProgressBar.generateProgressBar(insanity, 100, 30);
        System.out.println("Current sanity level: " + progressBar);
        if (insanity >= 100) {
            System.out.println("You have gone insane!");
        }
    }
}
