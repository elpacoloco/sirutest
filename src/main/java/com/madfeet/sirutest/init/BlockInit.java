package com.madfeet.sirutest.init;

import com.madfeet.sirutest.SiruTest;
import com.madfeet.sirutest.SiruTest.SiruItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = SiruTest.MOD_ID, bus = Bus.MOD)
@ObjectHolder(SiruTest.MOD_ID)
public class BlockInit {
    public static final Block sirubloque = null;
    public static final Block siruore = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0f, 15.0f)
                .sound(SoundType.STONE)).setRegistryName("siruore"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.7f, 6.0f)
                .sound(SoundType.SAND)).setRegistryName("sirubloque"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event){

        event.getRegistry().register(new BlockItem(siruore, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruore"));
        event.getRegistry().register(new BlockItem(sirubloque, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirubloque"));
    }

}
