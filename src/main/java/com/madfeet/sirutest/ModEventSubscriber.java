package com.madfeet.sirutest;
import com.madfeet.sirutest.init.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = SiruTest.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

    //@SubscribeEvent
    /*public static void onRegisterItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(
                setup(new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)),"siruvaconomicon")
        );
    }*/

    //@SubscribeEvent
    //public static void onRegisterBlocks(RegistryEvent.Register<Block> event){
        //event.getRegistry().registerAll(
                //setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "sirubloque")
       // );
    //}

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(SiruTest.MOD_ID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }
}
