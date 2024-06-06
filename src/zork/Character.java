package zork;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Character {
    String id, name, description;
    Room room;
    ArrayList<Room> rooms = Game.getRooms();

    public Character(String id, String name, String description, Room room) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getRoom(){
        return room;
    }

    // public String appearInRoom(List<String> availableRooms) {
    //     Random rand = new Random();
    //     return availableRooms.get(rand.nextInt(availableRooms.size()));
    // }

    public void randomRoom(Character character){
        room = rooms.get((int)Math.random()*(rooms.size()-1)); //generates a random room
        if(character.getName().equals("Danny")){ //just use if commands to restrict different characters
            while(character.getRoom().getRoomName().equals("Room 237")) //use this to restrict which rooms the specific character can't go in
                room = rooms.get((int)Math.random()*(rooms.size()-1)); 
        }
    }

}

// class Wendy extends Character {
//     public Wendy() {
//         super("wendy", "Wendy", "A slender woman with long, dark hair and wide, expressive eyes.");
//     }

//     @Override
//     public String appearInRoom(List<String> availableRooms) {
//         return super.appearInRoom(availableRooms);
//     }
// }

// class Danny extends Character {
//     private List<String> limitedRooms;

//     public Danny(List<String> limitedRooms) {
//         super("danny", "Danny", "A young boy with blond hair and a serious, often anxious expression, wearing the same expression now.");
//         this.limitedRooms = limitedRooms;
//     }

//     @Override
//     public String appearInRoom(List<String> availableRooms) {
//         return super.appearInRoom(limitedRooms);
//     }
// }

// class Dick extends Character {
//     public Dick() {
//         super("dick", "Dick", "A tall, middle-aged African-American man with a kind face and a calm demeanor.");
//     }
// }

// class NakedLadyNakedMan extends Character {
//     public NakedLadyNakedMan() {
//         super("nudist", "Naked Lady/Naked Man", "Scaring people off with their nudes, a decaying, nude person who can switch from female to male, limited to room 237.");
//     }

//     @Override
//     public String appearInRoom(List<String> availableRooms) {
//         return "237";
//     }
// }

// class AlcoholicBartender extends Character {
//     public AlcoholicBartender() {
//         super("bartender", "Alcoholic Bartender", "A disheveled man with piercing eyes, a receding hairline, and an increasingly wild appearance. Always found by the bar in the room.");
//     }

//     @Override
//     public String appearInRoom(List<String> availableRooms) {
//         return "Bar Room";
//     }
// }

// class WeirdTwins extends Character {
//     public WeirdTwins() {
//         super("thetwins", "The Weird Twins", "Identical young girls with long, dark hair, wearing matching blue dresses and a hauntingly vacant stare. They can appear in random rooms.");
//     }

//     @Override
//     public String appearInRoom(List<String> availableRooms) {
//         return super.appearInRoom(availableRooms);
//     }
// }

// class MonsieurGrady extends Character {
//     public MonsieurGrady() {
//         super("monsieurgrady", "Monsieur Grady", "A distinguished, elderly man with a well-groomed appearance, dressed in a formal suit.");
//     }
// }

// class BossManDan extends Character {
//     public BossManDan() {
//         super("bossguy", "'Boss Man Dan' AKA Stuart Ullman", "A neatly dressed, middle-aged man, roughly 5'11\", though he tells people he's 6 foot. Well-polished and always caught wearing a freshly dry-cleaned black suit.");
//     }
// }

// // Usage Example from chat gpt

// class Main {
//     public static void main(String[] args) {
//         List<String> availableRooms = Arrays.asList("101", "102", "103", "104", "105", "106"); // waiting on brianna
//         List<String> limitedRoomsForDanny = Arrays.asList("101", "102", "103"); // waitng on biranna

//         Wendy wendy = new Wendy();
//         Danny danny = new Danny(limitedRoomsForDanny);
//         NakedLadyNakedMan nudist = new NakedLadyNakedMan();
//         AlcoholicBartender bartender = new AlcoholicBartender();
//         WeirdTwins twins = new WeirdTwins();

//         System.out.println("Wendy appears in room: " + wendy.appearInRoom(availableRooms));
//         System.out.println("Danny appears in room: " + danny.appearInRoom(availableRooms));
//         System.out.println("Naked Lady/Naked Man appears in room: " + nudist.appearInRoom(availableRooms));
//         System.out.println("Alcoholic Bartender appears in room: " + bartender.appearInRoom(availableRooms));
//         System.out.println("The Weird Twins appear in room: " + twins.appearInRoom(availableRooms));
//     }
// }
