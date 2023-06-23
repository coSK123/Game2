package com.src.Items;
import com.src.Characters.Character;
public class HealthPotion extends Item implements ItemMethods{

    public HealthPotion() {
        this.name = "Healthpotion";

    }

    @Override
    public void use(Character player) {
        player.setCurrrentHealth(player.getCurrrentHealth()+20);
    }
}
