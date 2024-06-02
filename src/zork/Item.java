package zork;

public class Item extends OpenableObject {
  private int weight;
  private String name;
  private boolean isOpenable;
  private String description;
  private String shortDescrption;

  public Item(int weight, String name, boolean isOpenable) {
    this.weight = weight;
    this.name = name;
    this.isOpenable = isOpenable;
  }

  public Item(int weight, String name, String description, String shortDescription, boolean isOpenable) {
      this.weight = weight;
      this.name = name;
      this.description = description;
      this.isOpenable = isOpenable;
      this.shortDescrption = shortDescription;
  }

  public String getDescription(){
    return description;
  }

  public String getShortDescription(){
    return shortDescrption;
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
