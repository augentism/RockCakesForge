package com.augentism.rockcakes.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RawRockCake extends Item {
    public RawRockCake() {
        super(new Item.Properties()
                .group(ItemGroup.FOOD)
                .food(new Food.Builder()
                        .hunger(2)
                        .saturation(1.2f)
                        .effect( () -> new EffectInstance(Effects.MINING_FATIGUE, 200, 1), 0.5f)
                        .build())
        );
    }
}
