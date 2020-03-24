package com.madfeet.sirutest.events;

import com.madfeet.sirutest.SiruTest;
import com.madfeet.sirutest.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = SiruTest.MOD_ID, bus = Bus.FORGE)
public class SiruJumpEvent {

    @SubscribeEvent
    public static void SiruJumpEvent(LivingEvent.LivingJumpEvent event){
        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();
        world.setBlockState(livingEntity.getPosition().add(0, 5 , 0), BlockInit.sirubloque.getDefaultState());
        //livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,600, 255));
        livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE,5000, 255));
        livingEntity.setGlowing(true);
    }
}
