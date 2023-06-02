package com.src.Characters.Loot;

import com.src.Characters.Character;

public interface LootMethods {
    void getNormalLoot(Character player);

    void getSpecialLoot(Character player);

    void dropLoot(Character player);
}
