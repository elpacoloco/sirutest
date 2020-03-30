package com.madfeet.sirutest.objects.blocks;

import com.madfeet.sirutest.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockQuarry extends Block {
    public BlockQuarry(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        LOGGER.debug("1");
        return ModTileEntityTypes.QUARRY.get().create();
    }
}
