package com.src.Characters;

import com.src.Characters.Enemies.Enemy;
import com.src.Items.Item;
import com.src.Weapons.Weapon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class Character {
    protected int maxHealth;
    protected int currrentHealth;
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

    protected List<Item> items = new ArrayList<>();

    public void attack(Enemy enemy){

    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrrentHealth() {
        return currrentHealth;
    }

    public void setCurrrentHealth(int currrentHealth) {

        this.currrentHealth = currrentHealth;
        if(this.currrentHealth > maxHealth){
            this.currrentHealth = maxHealth;
        }
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(Item item) {
        boolean found = false;
       for(int i = 0; i< items.size();i++) {
           if (Objects.equals(items.get(i).getName(), item.getName())) {
               items.get(i).setQuantity(items.get(i).getQuantity() + 1);
               found = true;
           }
       }
       if(!found){
           item.setQuantity(1);
           this.items.add(item);
       }


    }
}
