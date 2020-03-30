package com.madfeet.sirutest.init;

import com.madfeet.sirutest.SiruTest;
import com.madfeet.sirutest.SiruTest.SiruItemGroup;
import com.madfeet.sirutest.objects.items.SpecialItem;
import com.madfeet.sirutest.objects.items.TurtleHat;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;
import java.util.stream.Stream;

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

    //ARMOR
    public static final Item sirucasco = null;
    public static final Item sirupiernas = null;
    public static final Item sirucuerpo = null;
    public static final Item sirubotas = null;


    public static final Item tortugorro = null;


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

        //ARMOR
        //new ArmorItem(MATERIAL, EQUIP SLOT, properties) -> para especificar uno vanilla ArmorMaterial. (Diamond, Iron, etc.)
        event.getRegistry().register(new ArmorItem(SiruArmorMaterial.SIRU, EquipmentSlotType.HEAD, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirucasco"));
        event.getRegistry().register(new ArmorItem(SiruArmorMaterial.SIRU, EquipmentSlotType.CHEST, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirucuerpo"));
        event.getRegistry().register(new ArmorItem(SiruArmorMaterial.SIRU, EquipmentSlotType.LEGS, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirupiernas"));
        event.getRegistry().register(new ArmorItem(SiruArmorMaterial.SIRU, EquipmentSlotType.FEET, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("sirubotas"));
        //event.getRegistry().register(new TortuGorro().setRegistryName("tortugorro"));

        //event.getRegistry().register(new ArmorItem(SiruTurtleArmor.TORTU, EquipmentSlotType.HEAD, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("tortugorro"));

        //event.getRegistry().register(new Item(new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("tortugorro"));
        //event.getRegistry().register(new ArmorItem(new ArmorMaterial(), EquipmentSlotType.HEAD, new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)).setRegistryName("tortugorro"));
    }

    public enum SiruItemTier implements IItemTier {
        //(haverstlevel, durability, efficiency, dmg, enchantability, item for repair)

        SIRUTIER(4, 1500, 15.0f, 7.0f, 200, () ->{
            return Ingredient.fromItems(BlockInit.siruore);
        }),

        TORTUTIER(4, 1500, 15.0f, 7.0f, 200, () ->{
            return Ingredient.fromItems(BlockInit.siruore);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float damage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        SiruItemTier(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Supplier<Ingredient> repairMaterial){
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

    /*public enum TortuMaterial implements IArmorMaterial{
        //name(id+layer, maxDmg, dmgReduction[]{boots, legs, chest, head}, enchantability, sound, toughness. ingredientSupplier)

        TORTU(SiruTest.MOD_ID + ":tortu", 5, new int[] {7, 9, 11, 5}, 420, SoundEvents.field_226124_Y_, 6.9f, () -> {
            return Ingredient.fromItems(ItemInit.siruvaconomicon);
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        TortuMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn,
                                  float toughnessIn, Supplier<Ingredient> repairMaterialIn){
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<Ingredient>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor; //multiplica el facto de dmg por el max_damage del slot que se pide
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }*/

    public enum SiruArmorMaterial implements IArmorMaterial{
        //name(id+layer, maxDmg, dmgReduction[]{boots, legs, chest, head}, enchantability, sound, toughness. ingredientSupplier)
        SIRU(SiruTest.MOD_ID + ":siru", 5, new int[] {7, 9, 11, 5}, 420, SoundEvents.field_226124_Y_, 6.9f, () -> {
            return Ingredient.fromItems(ItemInit.siruvaconomicon);
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private SiruArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn,
                                  float toughnessIn, Supplier<Ingredient> repairMaterialIn){
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<Ingredient>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor; //multiplica el facto de dmg por el max_damage del slot que se pide
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }

}
