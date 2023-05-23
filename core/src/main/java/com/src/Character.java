package com.src;

public abstract class Character {
    protected int health;
    protected int strength;
    protected int dexterity;
    protected int evasion;
    protected int defence;
    protected int money;
    protected int level;
    protected int experiencePoints;
    protected int ecperiencePointsTillNextLevel;
    protected Weapon mainHand;
    protected Weapon offHand;

    public int attack(){
        return 1;
    }
}
