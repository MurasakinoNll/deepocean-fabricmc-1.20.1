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
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORTDEEPSEAKELP_KEY = registryKey("shortdeepseakelp");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALLDEEPSEAKELP_KEY = registryKey("talldeepseakelp");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ASCOMYCOTA_KEY = registryKey("ascomycota");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(context, SHORTDEEPSEAKELP_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SHORTDEEPSEAKELP.getDefaultState())))));
        register(context, TALLDEEPSEAKELP_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TALLDEEPSEAKELP.getDefaultState())))));
        register(context, ASCOMYCOTA_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(32, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ASCOMYCOTA.getDefaultState())))));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(HaraksDeepOceans.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
