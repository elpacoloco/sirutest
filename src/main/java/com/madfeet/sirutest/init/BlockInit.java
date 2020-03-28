package com.madfeet.sirutest.init;

import com.madfeet.sirutest.SiruTest;
import com.madfeet.sirutest.SiruTest.SiruItemGroup;
import com.madfeet.sirutest.objects.blocks.SpecialBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
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
    public static final Block sirubloquesp = null;

    //public static final Block siruquarry = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0f, 15.0f)
                .sound(SoundType.STONE)).setRegistryName("siruore"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.7f, 6.0f).sound(SoundType.SAND)).setRegistryName("sirubloque"));

        //event.getRegistry().register(new BlockQuarry(Block.Properties.create(Material.IRON)).setRegistryName("siruquarry"));

        //CUSTOM
        event.getRegistry().register(new SpecialBlock(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(2.0f, 10.0f)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.GLASS).lightValue(4)
                .slipperiness(1.2f)
                .speedFactor(0.7f)
                .noDrops()).setRegistryName("sirubloquesp"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new BlockItem(siruore, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruore"));
        event.getRegistry().register(new BlockItem(sirubloque, new Item.Properties().maxStackSize(16).group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirubloque"));
        event.getRegistry().register(new BlockItem(sirubloquesp, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirubloquesp"));
        //event.getRegistry().register(new BlockItem(siruquarry, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruquarry"));
    }

}
