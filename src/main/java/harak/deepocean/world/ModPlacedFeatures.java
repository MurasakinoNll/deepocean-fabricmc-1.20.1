package harak.deepocean.world;

import harak.deepocean.HaraksDeepOceans;
import harak.deepocean.world.gen.feature.ModOceanPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SDSKP = registryKey("sdskp");
    public static final RegistryKey<PlacedFeature> TDSKP = registryKey("tdskp");
    public static final RegistryKey<PlacedFeature> ASCOMYCOTA = registryKey("ascomycota");


    public static void bootstrap(Registerable<PlacedFeature> context){
        var ConfiguredFeatureRegistryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

       register(context, SDSKP, ConfiguredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.SHORTDEEPSEAKELP_KEY), ModOceanPlacedFeatures.seagrassModifiers(42));
       register(context, TDSKP, ConfiguredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.TALLDEEPSEAKELP_KEY), ModOceanPlacedFeatures.seagrassModifiers(48));
       register(context, ASCOMYCOTA, ConfiguredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.ASCOMYCOTA_KEY), ModOceanPlacedFeatures.seagrassModifiers(50));

    }

    public static RegistryKey<PlacedFeature> registryKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(HaraksDeepOceans.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
