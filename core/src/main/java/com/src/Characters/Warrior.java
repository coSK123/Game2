package com.src.Characters;

import com.src.Characters.Enemies.Enemy;
import com.src.Weapons.WarriorSword;

import java.security.SecureRandom;

import static com.badlogic.gdx.math.MathUtils.random;

public class Warrior extends Character implements CharacterMethods {

    public Warrior(){
        this.maxHealth = 100;
        this.currrentHealth = 100;
        this.mainHand = new WarriorSword();
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
        return "Warrior \n" +
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
        SecureRandom random = new SecureRandom();
        int strengthdmg = random.nextInt(strength+1);
        int weapondmg = random.nextInt(mainHand.getDamage()-5)+5;

        enemy.setHealth(enemy.getHealth()-( strengthdmg+ weapondmg));
    }

    @Override
    public int defend() {
        //TODO
        return 0;
    }

    @Override
    public boolean evade() {
        //TODO
        return false;
    }

}
