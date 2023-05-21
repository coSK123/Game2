package com.src;

public class Warrior extends Character{

    public Warrior(){
        this.health = 100;
        this.mainHand = new WarriorSword();
        this.strength = 12;
        this.dexterity = 9;
        this.defence = 10;
        this.evasion = 5;
        this.ecperiencePointsTillNextLevel = 2;
        this.experiencePoints = 0;
        this.level = 1;
        this.money = 5;
        this.offHand = null;
    }
    public int attack(){
        System.out.println(strength/4+ mainHand.getDamage());
        return strength/4+ mainHand.getDamage();
    }
}
