package com.src.Characters.Enemies;


import com.src.Characters.Character;
import com.src.Characters.Loot.Loot;
import com.src.Weapons.Weapon;

public abstract class Enemy {



        protected int health;
        protected int strength;
        protected int dexterity;
        protected int evasion;
        protected int defence;
        protected int gold;
        protected Weapon mainHand;
        protected Weapon offHand;
        protected Loot loot;

        public void attack(com.src.Characters.Character character){

        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }




    public abstract void droploot(Character player);
}
