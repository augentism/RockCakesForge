package com.augentism.rockcakes;

import com.augentism.rockcakes.blocks.RockCakeOre;
import com.augentism.rockcakes.items.CookedRockCake;
import com.augentism.rockcakes.items.RawRockCake;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RockCakes.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RockCakes.MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<Block> ROCKCAKE_ORE = BLOCKS.register("rockcake_ore", RockCakeOre::new);
    public static final RegistryObject<Item> ROCKCAKE_ORE_ITEM = ITEMS.register("rockcake_ore", () ->
            new BlockItem(
                    ROCKCAKE_ORE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );
    public static final RegistryObject<CookedRockCake> COOKEDROCKCAKE = ITEMS.register("cookedrockcake", CookedRockCake::new);
    public static final RegistryObject<RawRockCake> RAWROCKCAKE = ITEMS.register("rawrockcake", RawRockCake::new);
}

