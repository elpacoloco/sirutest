package com.madfeet.sirutest.objects.items;

import com.madfeet.sirutest.init.BlockInit;
import com.madfeet.sirutest.util.helpers.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SpecialItem extends Item {
    public SpecialItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardHelper.isHoldingShift()){
            tooltip.add(new StringTextComponent("SIRUVAQUEWITAAAA"));
        }else{
            tooltip.add(new StringTextComponent("Hold "+ "\u00A7e" + "SHIFT" + "\u00A77" + "para sirurerarorar"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 500 , 255));
        worldIn.setRainStrength(1.0f);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        entity.getEntityWorld().setBlockState(entity.getPosition().down(), BlockInit.sirubloque.getDefaultState());
        return false;
    }
}
