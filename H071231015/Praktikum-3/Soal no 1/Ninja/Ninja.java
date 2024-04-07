package Ninja;

import java.io.IOException;
import javax.sound.sampled.*;

// Class Induk atau superclass
public abstract class Ninja{
    public String name;
    public double attack;
    public double health;
    public double armor;
    public double chakra;
    public Weapon weapon;

    public Ninja(String name, double attack,double health, double armor, double chakra) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.armor = armor;
        this.chakra = chakra;
    }

    public Ninja(String name, double attack,double health, double armor, double chakra, Weapon weapon) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.armor = armor;
        this.chakra = chakra;
        this.weapon = weapon;
    }

    public String getName(){
        return name;
    }

    public double getAttack() {
        return attack;
    }

    public double getHealth() {
        return health;
    }

    public double getArmor(){
        return armor;
    }

    public double getChakra(){
        return chakra;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public abstract void skill(Ninja target) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException;

    public void useWeapon(){
        System.out.println(weapon.name + "'s bonus : ++" + weapon.attack + " Attack ++" + weapon.armor + " Armor");
        attack += weapon.attack;
        armor += weapon.armor;
    }

}