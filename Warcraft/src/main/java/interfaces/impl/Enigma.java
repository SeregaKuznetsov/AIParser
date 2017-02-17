package interfaces.impl;

import interfaces.Armor;
import interfaces.Warrior;
import interfaces.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sergey on 14.02.2017.
 */

@Component
public class Enigma implements Warrior{

    @Autowired
    private Armor armor;
    @Autowired
    private Weapon weapon;

    public Enigma(){};

    public Enigma(Armor armor, Weapon weapon){
        this.armor = armor;
        this.weapon = weapon;

    }

    public void attack() {
        System.out.println("I'm attack! with " + weapon);
    }

    public void defence() {
        System.out.println("I'm defense! with " + armor);
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
