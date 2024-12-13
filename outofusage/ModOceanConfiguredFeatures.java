package harak.deepocean.world.gen.feature;

import harak.deepocean.HaraksDeepOceans;
import harak.deepocean.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModOceanConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORTDEEPSEAGRASS_SIMPLE = ConfiguredFeatures.of("shortdeepseagrass_simple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASCOMYCOTA_SIMPLE = ConfiguredFeatures.of("ascomycota_simple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALLDEEPSEAGRASS_SIMPLE = ConfiguredFeatures.of("talldeepseagrass_simple");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ConfiguredFeatures.register(featureRegisterable, SHORTDEEPSEAGRASS_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHORTDEEPSEAGRASS)));
        ConfiguredFeatures.register(featureRegisterable, TALLDEEPSEAGRASS_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TALLDEEPSEAGRASS)));
        ConfiguredFeatures.register(featureRegisterable, ASCOMYCOTA_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ASCOMYCOTA)));

    }

}
