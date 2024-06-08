package zork.commands;

import java.util.ArrayList;
import zork.Item;
import zork.Game;
import zork.Player;

public class objective {
    private static ArrayList<Item> carParts = new ArrayList<Item>();
    
    public static String printObjective(){
        //"snowcat_engine_part", "screwdriver", "fuel_can", "wires", "battery"
        carParts.removeAll(carParts);
        carParts.add(Game.getAllItems().get("snowcat_engine_part"));
        carParts.add(Game.getAllItems().get("screwdriver"));
        carParts.add(Game.getAllItems().get("fuel_can"));
        carParts.add(Game.getAllItems().get("wires"));
        carParts.add(Game.getAllItems().get("battery"));
        int carPartsFound = 0;
        if(Game.checkObjective1()){
            return "Objective: Find SnowCat Repair Manual.";
        }else if(Game.checkObjective2()){
            String listOfCarParts = "";
            for (int i = 0; i < carParts.size(); i++) {
                listOfCarParts += i+1 + ". Find " + carParts.get(i).getName();
                if(Player.getInventory().containsItem(carParts.get(i))){
                    listOfCarParts += " (Found)";
                    carPartsFound++;
                }
                listOfCarParts += "\n";
            }
            if(carPartsFound == 5)
                return "Objective: Go back to SnowCat and fix it.";

            return "Objective: Fix SnowCat\n" + listOfCarParts;
        }else if(Game.checkObjectiveInsane()){
            return "Kill Your Family.";
        }
        return "You do not have an objective at the moment. Explore the map to find items and objectives";
    }

    public static int getCarPartsFound(){
        return carParts.size();
    }
}
