package com.madfeet.sirutest.init;

import com.madfeet.sirutest.SiruTest;
import com.madfeet.sirutest.world.biomes.SiruBiome;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, SiruTest.MOD_ID);

    public static RegistryObject<Biome> SIRU_BIOME = BIOMES.register("siru_biome", () -> new SiruBiome(
            new Biome.Builder()
                    .precipitation(Biome.RainType.SNOW)
                    .scale(1.2f)
                    .temperature(0.5f)
                    .waterColor(16724639)
                    .waterFogColor(16762304)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlockInitNew.DEF_BLOCK.get().getDefaultState(), BlockInit.siruore.getDefaultState(), Blocks.LAPIS_BLOCK.getDefaultState()))
                    .category(Biome.Category.PLAINS)
                    .downfall(0.5f) //probabilidad de llover/nevar
                    .depth(0.12f) //How lowdown or highup the biome is -> default = 0.125
                    .parent(null)));
    //SurfaceBuilderConfig(topBlock (grass), MidBlock (dirt), underWater);

    public static void registerBiomes(){
        registerBiome(SIRU_BIOME.get(), Type.PLAINS, Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types){
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
    }
}
