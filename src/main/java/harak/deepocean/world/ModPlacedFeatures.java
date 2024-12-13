package harak.deepocean.world;

import harak.deepocean.HaraksDeepOceans;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> SHORTDEEPSEAGRASS = registryKey("shortdeepseagrass");
    public static final RegistryKey<PlacedFeature> TALLDEEPSEAGRASS = registryKey("talldeepseagrass");
    public static final RegistryKey<PlacedFeature> ASCOMYCOTA = registryKey("ascomycota");
    public static List<PlacementModifier> seagrassModifiers(int count) {
        return List.of(SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP, CountPlacementModifier.of(count), BiomePlacementModifier.of());
    }

    public static void bootstrap(Registerable<PlacedFeature> context){
        var ConfiguredFeatureRegistryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

       register(context, ASCOMYCOTA, ConfiguredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.ASCOMYCOTA), ModPlacedFeatures.seagrassModifiers(50));
       register(context, SHORTDEEPSEAGRASS, ConfiguredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.SHORTDEEPSEAGRASS), ModPlacedFeatures.seagrassModifiers(24));
       register(context, TALLDEEPSEAGRASS, ConfiguredFeatureRegistryLookup.getOrThrow(ModConfiguredFeatures.TALLDEEPSEAGRASS), ModPlacedFeatures.seagrassModifiers(24));

    }

    public static RegistryKey<PlacedFeature> registryKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(HaraksDeepOceans.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

/*
package harak.deepocean.world.gen.feature;

import harak.deepocean.HaraksDeepOceans;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModOceanPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SHORTDEEPSEAGRASS = PlacedFeatures.of("shortdeepseagrass");
    public static final RegistryKey<PlacedFeature> TALLDEEPSEAGRASS = PlacedFeatures.of("talldeepseagrass");
    public static final RegistryKey<PlacedFeature> ASCOMYCOTA = PlacedFeatures.of("ascomycota");
    public static List<PlacementModifier> seagrassModifiers(int count) {
        return List.of(SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP, CountPlacementModifier.of(count), BiomePlacementModifier.of());
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference2 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.SHORTDEEPSEAGRASS);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference3 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.TALLDEEPSEAGRASS);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference5 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.ASCOMYCOTA);
        PlacedFeatures.register(featureRegisterable, TALLDEEPSEAGRASS, reference3, seagrassModifiers(80));
        PlacedFeatures.register(featureRegisterable, SHORTDEEPSEAGRASS, reference2, seagrassModifiers(80));
        PlacedFeatures.register(featureRegisterable, ASCOMYCOTA, reference5, seagrassModifiers(80));


    }

}

 */