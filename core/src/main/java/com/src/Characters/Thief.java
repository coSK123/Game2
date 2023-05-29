package com.src.Characters;

import com.src.Weapons.ThiefsDagger;
import com.src.Weapons.WarriorSword;

public class Thief extends Character implements CharacterMethods{
    public Thief() {
        this.health = 100;
        this.mainHand = new ThiefsDagger();
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

    @Override
    public String toString() {
        return "Thief \n" +
            "health=" + health + "\n"+
            "strength=" + strength +"\n"+
            "dexterity=" + dexterity +"\n"+
            "evasion=" + evasion +"\n"+
            "defence=" + defence +"\n"+
            "money=" + money +"\n"+
            "mainHand=" + mainHand +"\n"+
            "offHand=" + offHand;
    }
    @Override
    public int attack() {
        return dexterity/2+ mainHand.getDamage();
    }

    @Override
    public int defend() {
        return 0;
    }

    @Override
    public boolean evade() {
        return false;
    }
}