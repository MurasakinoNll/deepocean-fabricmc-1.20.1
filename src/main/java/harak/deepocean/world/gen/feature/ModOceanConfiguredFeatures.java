package harak.deepocean.world.gen.feature;

import harak.deepocean.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModOceanConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORTDEEPSEAKELP_SIMPLE = ConfiguredFeatures.of("shortdeepseakelp_simple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASCOMYCOTA_SIMPLE = ConfiguredFeatures.of("ascomycota_simple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALLDEEPSEAKELP_SIMPLE = ConfiguredFeatures.of("talldeepseakelp_simple");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ConfiguredFeatures.register(featureRegisterable, SHORTDEEPSEAKELP_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHORTDEEPSEAKELP)));
        ConfiguredFeatures.register(featureRegisterable, TALLDEEPSEAKELP_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ASCOMYCOTA)));
        ConfiguredFeatures.register(featureRegisterable,ASCOMYCOTA_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ASCOMYCOTA)));

    }
}
