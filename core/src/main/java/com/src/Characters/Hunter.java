package com.src.Characters;

import com.src.Characters.Enemies.Enemy;
import com.src.Weapons.HuntersBow;

public class Hunter extends Character implements CharacterMethods{
    public Hunter() {
        this.maxHealth = 100;
        this.currrentHealth = 100;
        this.mainHand = new HuntersBow();
        this.strength = 12;
        this.dexterity = 9;
        this.defence = 10;
        this.evasion = 5;
        this.ecperiencePointsTillNextLevel = 2;
        this.experiencePoints = 0;
        this.level = 1;
        this.gold = 5;
        this.offHand = null;
    }

    @Override
    public String toString() {
        return "Hunter \n" +
            "health=" + currrentHealth + "\n"+
            "strength=" + strength +"\n"+
            "dexterity=" + dexterity +"\n"+
            "evasion=" + evasion +"\n"+
            "defence=" + defence +"\n"+
            "money=" + gold +"\n"+
            "mainHand=" + mainHand +"\n"+
            "offHand=" + offHand;
    }
    @Override
    public void attack(Enemy enemy) {
         enemy.setHealth(enemy.getHealth()-(dexterity/4+ mainHand.getDamage()));
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
