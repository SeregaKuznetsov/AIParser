package interfaces.impl;

import interfaces.Armor;
import interfaces.Warrior;
import interfaces.Weapon;

/**
 * Created by Sergey on 14.02.2017.
 */
public class Ember implements Warrior{

    private Armor armor;
    private Weapon weapon;


    public Ember(){}

    public Ember(Armor armor, Weapon weapon){
        this.armor = armor;
        this.weapon = weapon;

    }

    public void attack() {
        System.out.println("I'm attack with! " + weapon);
    }

    public void defence() {
        System.out.println("I'm defense! " + armor);
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
