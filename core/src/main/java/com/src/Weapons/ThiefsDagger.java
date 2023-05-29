package com.src.Weapons;

public class ThiefsDagger extends Weapon{
    private int damage = 6;
    private int criticalStrikeChance = 30;
    private String name = "Thief's Dagger";

    public ThiefsDagger() {
    }

    @Override
    public String toString() {
        return  name ;
    }
}
