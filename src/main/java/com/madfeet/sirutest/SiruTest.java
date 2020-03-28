package com.madfeet.sirutest;

import com.madfeet.sirutest.init.BlockInit;
import com.madfeet.sirutest.init.ItemInit;
import com.madfeet.sirutest.world.gen.SiruOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
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
