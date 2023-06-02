package com.src.Characters;

import com.src.Characters.Enemies.Enemy;
import com.src.Weapons.Weapon;

public abstract class Character {
    protected int health;
    protected int strength;
    protected int dexterity;
    protected int evasion;
    protected int defence;
    protected int gold;
    protected int level;
    protected int experiencePoints;
    protected int ecperiencePointsTillNextLevel;
    protected Weapon mainHand;
    protected Weapon offHand;

    public void attack(Enemy enemy){

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getEcperiencePointsTillNextLevel() {
        return ecperiencePointsTillNextLevel;
    }

    public void setEcperiencePointsTillNextLevel(int ecperiencePointsTillNextLevel) {
        this.ecperiencePointsTillNextLevel = ecperiencePointsTillNextLevel;
    }

    public Weapon getMainHand() {
        return mainHand;
    }

    public void setMainHand(Weapon mainHand) {
        this.mainHand = mainHand;
    }

    public Weapon getOffHand() {
        return offHand;
    }

    public void setOffHand(Weapon offHand) {
        this.offHand = offHand;
    }
}
