package com.src.Characters.Loot;

import com.src.Characters.Character;

import java.util.Random;

public class SkeletonLoot extends Loot implements LootMethods{
    public SkeletonLoot() {
        Random random = new Random();
        this.gold = random.nextInt(6);
        this.exp = random.nextInt(1,4);
        System.out.println(this.exp);
    }

    @Override
    public void getNormalLoot(Character player) {
        player.setGold(player.getGold()+gold);
        player.setExperiencePoints(player.getExperiencePoints()+exp);
        player.setEcperiencePointsTillNextLevel(player.getEcperiencePointsTillNextLevel()-exp);
    }

    @Override
    public void getSpecialLoot(Character player) {

    }

    @Override
    public void dropLoot(Character player) {
        getNormalLoot(player);
        getSpecialLoot(player);
    }
}
