package com.src.Weapons;

public class WarriorSword extends Weapon {
    private int damage = 10;
    private String name = "WarriorSword";


    public WarriorSword(){

    }

    @Override
    public String toString() {
        return name;

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
