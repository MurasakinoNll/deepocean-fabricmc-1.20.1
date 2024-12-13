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
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORTDEEPSEAGRASS = registryKey("shortdeepseagrass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASCOMYCOTA = registryKey("ascomycota");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALLDEEPSEAGRASS = registryKey("talldeepseagrass");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, ASCOMYCOTA, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ASCOMYCOTA.getDefaultState())))));
        register(context, TALLDEEPSEAGRASS, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TALLDEEPSEAGRASS.getDefaultState())))));
        register(context, SHORTDEEPSEAGRASS, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHORTDEEPSEAGRASS.getDefaultState())))));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(HaraksDeepOceans.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

/*
  public static final RegistryKey<ConfiguredFeature<?, ?>> SHORTDEEPSEAGRASS = ConfiguredFeatures.of("shortdeepseagrass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASCOMYCOTA = ConfiguredFeatures.of("ascomycota");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALLDEEPSEAGRASS = ConfiguredFeatures.of("talldeepseagrass");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ConfiguredFeatures.register(featureRegisterable, SHORTDEEPSEAGRASS, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHORTDEEPSEAGRASS)));
        ConfiguredFeatures.register(featureRegisterable, TALLDEEPSEAGRASS, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TALLDEEPSEAGRASS)));
        ConfiguredFeatures.register(featureRegisterable, ASCOMYCOTA, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ASCOMYCOTA)));

    }
 */