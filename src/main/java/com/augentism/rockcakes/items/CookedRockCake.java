package com.augentism.rockcakes.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class CookedRockCake extends Item {
    public CookedRockCake() {
        super(new Item.Properties()
                .group(ItemGroup.FOOD)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(6f)
                        .build())
        );
    }
}
