package com.src.Characters;

import com.src.Weapons.Weapon;

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

    public void attack(Character character){

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
