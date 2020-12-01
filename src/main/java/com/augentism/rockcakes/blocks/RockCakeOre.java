package com.augentism.rockcakes.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class RockCakeOre extends OreBlock {
    public RockCakeOre(){
        super(Block.Properties.create(Material.IRON)
                              .hardnessAndResistance(5.0f,6.0f)
                              .sound(SoundType.STONE)
                              .harvestLevel(1)
                              .harvestTool(ToolType.PICKAXE)
        );
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return super.getExpDrop(state, reader, pos, fortune, silktouch);
    }
}
