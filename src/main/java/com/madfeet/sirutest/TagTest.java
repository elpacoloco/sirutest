package com.madfeet.sirutest;

import com.madfeet.sirutest.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class TagTest {
    public TagTest(){
        ResourceLocation siruTagItem = new ResourceLocation(SiruTest.MOD_ID, "sirutagitem");
        Item item = ItemInit.siruvaconomicon;
        Boolean isInTag = ItemTags.getCollection().get(siruTagItem).contains(item);
        if(isInTag){
            //Algo
        }
    }

}
