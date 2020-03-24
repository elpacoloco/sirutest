package com.madfeet.sirutest.init;

import com.madfeet.sirutest.SiruTest;
import com.madfeet.sirutest.SiruTest.SiruItemGroup;
import com.madfeet.sirutest.objects.items.SpecialItem;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = SiruTest.MOD_ID, bus = Bus.MOD)
@ObjectHolder(SiruTest.MOD_ID)
public class ItemInit {

    //ITEMS
    public static final Item siruvarita = null;
    public static final Item monster_book = null;
    public static final Item siruvaconomicon = null;
    public static final Item siruespecial = null;

    //TOOLS
    public static final Item sirupico = null;
    public static final Item siruhacha = null;
    public static final Item sirupala = null;
    public static final Item siruazada = null;

    //WEAPONS
    public static final Item siruswordo = null;


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        //ITEMS
        event.getRegistry().register(new Item(new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruvarita"));
        event.getRegistry().register(new Item(new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP).food(new Food.Builder().hunger(6).saturation(1.2f).setAlwaysEdible().build())).setRegistryName("monster_book"));
        event.getRegistry().register(new Item(new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruvaconomicon"));
        event.getRegistry().register(new SpecialItem(new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruespecial"));

        //TOOLS
        event.getRegistry().register(new PickaxeItem(SiruItemTier.SIRUTIER, 4, 1.5f, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirupico"));
        event.getRegistry().register(new AxeItem(SiruItemTier.SIRUTIER, 4, 1.5f, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruhacha"));
        event.getRegistry().register(new HoeItem(SiruItemTier.SIRUTIER, 2.0f, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruazada"));
        event.getRegistry().register(new ShovelItem(SiruItemTier.SIRUTIER, 4, 1.5f, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirupala"));

        //WEAPONS
        event.getRegistry().register(new SwordItem(SiruItemTier.SIRUTIER, 7, 3.0f, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("siruswordo"));
    }

    public enum SiruItemTier implements IItemTier {
        //(haverstlevel, durability, efficiency, dmg, enchantability, item for repair)

        SIRUTIER(4, 1500, 15.0f, 7.0f, 200, () ->{
            return Ingredient.fromItems(BlockInit.sirubloque);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float damage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private SiruItemTier(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Supplier<Ingredient> repairMaterial){
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.damage = damage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<Ingredient>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.damage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }

}
