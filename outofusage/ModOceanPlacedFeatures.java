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
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference2 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.SHORTDEEPSEAGRASS_SIMPLE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference3 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.TALLDEEPSEAGRASS_SIMPLE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference5 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.ASCOMYCOTA_SIMPLE);
        PlacedFeatures.register(featureRegisterable, TALLDEEPSEAGRASS, reference3, seagrassModifiers(80));
        PlacedFeatures.register(featureRegisterable, SHORTDEEPSEAGRASS, reference2, seagrassModifiers(80));
        PlacedFeatures.register(featureRegisterable, ASCOMYCOTA, reference5, seagrassModifiers(80));


    }

}
