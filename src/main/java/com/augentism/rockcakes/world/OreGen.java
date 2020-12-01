package com.augentism.rockcakes.world;

import com.augentism.rockcakes.RegistryHandler;
import com.augentism.rockcakes.RockCakes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;


@Mod.EventBusSubscriber
public class OreGen {
//    @SubscribeEvent
//    public static void genOres(FMLLoadCompleteEvent event){
//        for(Biome biome : ForgeRegistries.BIOMES){
//            if(biome.getCategory() == Biome.Category.NETHER){
//
//            } else if (biome.getCategory() == Biome.Category.THEEND){
//
//            } else {
//
//            }
//        }
//    }
//
//    private static void genOre(Biome biome,
//                               int count,
//                               int bottomOffset,
//                               int topOffset,
//                               int max,
//                               OreFeatureConfig.FillerBlockType filler,
//                               BlockState defaultBlockState, int size){
//        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
//
//    }
    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres(){
        overworldOres.add(register("rockcake_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.ROCKCAKE_ORE.get().getDefaultState(), 8))
                .range(64).square() //Spawn height start
                .func_242731_b(64))); //Chunk spawn frequency

    }
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : netherOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore); //generating ores in the nether list
            }
        }
        if(event.getCategory().equals(Biome.Category.THEEND)){
            for(ConfiguredFeature<?, ?> ore : endOres){
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore); //generating ores in the end list
            }
        }
        for(ConfiguredFeature<?, ?> ore : overworldOres){
            if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore); //generating ores in the overworld list
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, RockCakes.MODID + ":" + name, configuredFeature);
    }
}
