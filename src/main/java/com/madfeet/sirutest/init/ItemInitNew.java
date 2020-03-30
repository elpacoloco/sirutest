package com.madfeet.sirutest.init;

import com.madfeet.sirutest.SiruTest;
import com.madfeet.sirutest.SiruTest.SiruItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, SiruTest.MOD_ID);
    public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item", () -> new Item(new Item.Properties().group(SiruItemGroup.SIRU_ITEM_GROUP)));
}
