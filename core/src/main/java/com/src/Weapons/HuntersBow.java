package com.src.Weapons;

public class HuntersBow extends Weapon{
    private int damage = 7;
    private int criticalStrikeChance = 50;
    private String name = "Hunter's Bow";

    public HuntersBow() {
    }

    @Override
    public String toString() {
        return  name;
    }
}
