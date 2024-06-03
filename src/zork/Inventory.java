package zork;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {
  private ArrayList<Item> items;
  private int maxWeight;
  private int currentWeight;

  public Inventory(int maxWeight) {
    this.items = new ArrayList<Item>();
    this.maxWeight = maxWeight;
    this.currentWeight = 0;
  }

  public int getMaxWeight() {
    return maxWeight;
  }

  public int getCurrentWeight() {
    return currentWeight;
  }

  public boolean addItem(Item item) {
    if (item.getWeight() + currentWeight <= maxWeight)
      return items.add(item);
    else {
      System.out.println("There is no room to add the item.");
      return false;
    }
  }

  public void removeItem(Item item){
    items.remove(item);
  }

  public boolean containsItem(Item item){
    for (Item i: items) {
      if(item.getName().equals(i.getName()))
        return true;
    }
    return false;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

}
