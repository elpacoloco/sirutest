package com.madfeet.sirutest;

import com.madfeet.sirutest.init.*;
import com.madfeet.sirutest.world.biomes.SiruBiome;
import com.madfeet.sirutest.world.gen.SiruOreGen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SiruTest.MOD_ID)
@Mod.EventBusSubscriber(modid = SiruTest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SiruTest {

    public static final String MOD_ID = "sirutest";
    public static SiruTest instance;
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public SiruTest(){
        //LOGGER.debug("Hello Siruvaco!");

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemInitNew.ITEMS.register(modEventBus);
        BlockInitNew.BLOCKS.register(modEventBus);

        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);

        BiomeInit.BIOMES.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("Registered block items: ");
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event){
        BiomeInit.registerBiomes();
    }

    private void setup(final FMLCommonSetupEvent event){

    }

    private void doClientStuff(final FMLClientSetupEvent event){

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event){

    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event){
        //Este método siempre antes del server start (FMLLoadCompleteEvent va bastante antes, así que bien)
        SiruOreGen.generateOre();
    }

    public static class SiruItemGroup extends ItemGroup{
        public static final SiruItemGroup SIRU_ITEM_GROUP = new SiruItemGroup(ItemGroup.GROUPS.length, "sirutab");

        private SiruItemGroup(int index, String label){
            super(index, label);
        }

        @Override
        public ItemStack createIcon(){
            return new ItemStack(ItemInit.siruvaconomicon);
            //return new ItemStack(BlockInit.sirubloque);
        }
    }


}
