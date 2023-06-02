package com.src.Characters.Enemies;

import com.src.Characters.Character;
import com.src.Characters.Loot.SkeletonLoot;
import com.src.Weapons.WarriorSword;

public class Skeleton extends Enemy implements EnemieMethods {
    public Skeleton() {
        this.health = 30;
        this.mainHand = new WarriorSword();
        this.strength = 4;
        this.dexterity = 4;
        this.defence = 4;
        this.evasion = 0;
        this.gold = 5;
        this.offHand = null;
        this.loot = new SkeletonLoot();
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth()-(mainHand.getDamage()-5));
    }

    @Override
    public int defend() {
        return 0;
    }

    @Override
    public boolean evade() {
        return false;
    }
    @Override
    public void droploot(Character player){
        loot.dropLoot(player);
    }
}
