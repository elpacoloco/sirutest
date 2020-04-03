package com.madfeet.sirutest.init;

import com.madfeet.sirutest.SiruTest;
import com.madfeet.sirutest.objects.blocks.SiruButtonBlock;
import com.madfeet.sirutest.objects.blocks.SiruPressurePlate;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, SiruTest.MOD_ID);

    public static final RegistryObject<Block> DEF_BLOCK = BLOCKS.register("def_block", () -> new Block(Block.Properties.create(Material.IRON)));

    //public static final RegistryObject<Block> SIRU_STAIRS = BLOCKS.register("siru_stairs", () -> new StairsBlock(() -> BlockInitNew.DEF_BLOCK.get().getDefaultState(), Block.Properties.create(Material.WOOD)));
    public static final RegistryObject<Block> SIRU_STAIRS = BLOCKS.register("siru_stairs", () -> new StairsBlock(() -> BlockInit.siruore.getDefaultState(), Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
    public static final RegistryObject<Block> SIRU_FENCE = BLOCKS.register("siru_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));

    public static final RegistryObject<Block> SIRU_BUTTON = BLOCKS.register("siru_button", () -> new SiruButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.GOLD)));
    public static final RegistryObject<Block> SIRU_PRESSURE_PLATE = BLOCKS.register("siru_pressure_plate", () -> new SiruPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD)));

}
