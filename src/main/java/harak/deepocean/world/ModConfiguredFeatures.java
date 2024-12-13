package harak.deepocean.world;

import harak.deepocean.HaraksDeepOceans;
import harak.deepocean.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORTDEEPSEAGRASS_SIMPLE = ConfiguredFeatures.of("shortdeepseagrass_simple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASCOMYCOTA_SIMPLE = ConfiguredFeatures.of("ascomycota_simple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALLDEEPSEAGRASS_SIMPLE = ConfiguredFeatures.of("talldeepseagrass_simple");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, ASCOMYCOTA_SIMPLE, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ASCOMYCOTA.getDefaultState())))));
        register(context, TALLDEEPSEAGRASS_SIMPLE, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TALLDEEPSEAGRASS.getDefaultState())))));
        register(context, SHORTDEEPSEAGRASS_SIMPLE, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHORTDEEPSEAGRASS.getDefaultState())))));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(HaraksDeepOceans.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

/*
  public static final RegistryKey<ConfiguredFeature<?, ?>> SHORTDEEPSEAGRASS_SIMPLE = ConfiguredFeatures.of("shortdeepseagrass_simple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASCOMYCOTA_SIMPLE = ConfiguredFeatures.of("ascomycota_simple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALLDEEPSEAGRASS_SIMPLE = ConfiguredFeatures.of("talldeepseagrass_simple");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ConfiguredFeatures.register(featureRegisterable, SHORTDEEPSEAGRASS_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHORTDEEPSEAGRASS)));
        ConfiguredFeatures.register(featureRegisterable, TALLDEEPSEAGRASS_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TALLDEEPSEAGRASS)));
        ConfiguredFeatures.register(featureRegisterable, ASCOMYCOTA_SIMPLE, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ASCOMYCOTA)));

    }
 */