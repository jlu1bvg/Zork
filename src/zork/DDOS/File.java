package zork.DDOS;

import zork.OpenableObject;

public class File{
  private int weight;
  private String name;
  private boolean isOpenable;

  public File(int weight, String name, boolean isOpenable) {
    this.weight = weight;
    this.name = name;
    this.isOpenable = isOpenable;
  }

  public void open() {
    if (!isOpenable)
      System.out.println("The " + name + " cannot be opened.");

  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isOpenable() {
    return isOpenable;
  }

  public void setOpenable(boolean isOpenable) {
    this.isOpenable = isOpenable;
  }

}
