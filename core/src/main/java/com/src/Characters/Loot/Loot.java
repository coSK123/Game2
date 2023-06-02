package com.src.Characters.Loot;

import com.src.Characters.Character;

public abstract class  Loot implements LootMethods{
    protected int gold;
    protected int exp;

    public void getNormalLoot(Character player){}

    public void getSpecialLoot(Character player){}

    public void dropLoot(Character player){}

}
