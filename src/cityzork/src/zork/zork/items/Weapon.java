package cityzork.src.zork.zork.items;

import cityzork.src.zork.zork.Effect;
import cityzork.src.zork.zork.Item;

public class Weapon extends Item {
    // private int weight;
    private int damage;

  
    

    

    public Weapon(int weight, String name, boolean isOpenable, int damage, Effect effect){
        super(weight, name, isOpenable, effect, true);
        this.damage = damage;
       

    }

    public String getWeapon() {
        return super.getName();
    }


    public Effect getEffect() {
        if (super.getEffect() != null) {
            return super.getEffect();
        }else{
            return null;
        }
            
       
        
    }

    public void setEffect(Effect effect) {
        super.setEffect(effect);
    }

    public int getWeight() {
        return super.getWeight();
      }
    
    // public void setWeight(int weight) {
    //     this.weight = weight;
    // }
    

    public String getName() {
        return super.getName();
    }
    
    public void setName(String name) {
        super.setName(name);
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
}
