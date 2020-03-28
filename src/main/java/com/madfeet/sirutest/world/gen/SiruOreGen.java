package com.madfeet.sirutest.world.gen;

import com.madfeet.sirutest.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class SiruOreGen {
    public static void generateOre(){
        for(Biome b : ForgeRegistries.BIOMES){
            if(b == Biomes.PLAINS){
                //CountRangeConfig(cantidad, bottomOffset, topOffset, maximum)
                ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 5, 5, 40));
                b.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.siruore.getDefaultState(), 10)).withPlacement(customConfig));
            }
        }
    }
}
