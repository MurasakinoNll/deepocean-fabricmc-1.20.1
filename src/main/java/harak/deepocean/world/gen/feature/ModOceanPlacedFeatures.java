package harak.deepocean.world.gen.feature;

import harak.deepocean.world.ModConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModOceanPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SDSKP = PlacedFeatures.of("sdskp");
    public static final RegistryKey<PlacedFeature> TDSKP = PlacedFeatures.of("tdskp");
    public static final RegistryKey<PlacedFeature> ASCOMYCOTA = PlacedFeatures.of("ascomycota");
    public static final RegistryKey<PlacedFeature> DEEPSEAGRASS_SIMPLE = PlacedFeatures.of("deepseagrass_simple");
    public static List<PlacementModifier> seagrassModifiers(int count) {
        return List.of(SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP, CountPlacementModifier.of(count), BiomePlacementModifier.of());
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference = registryEntryLookup.getOrThrow(ModConfiguredFeatures.ASCOMYCOTA_KEY);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference2 = registryEntryLookup.getOrThrow(ModConfiguredFeatures.SHORTDEEPSEAKELP_KEY);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference3 = registryEntryLookup.getOrThrow(ModConfiguredFeatures.TALLDEEPSEAKELP_KEY);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference4 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.SHORTDEEPSEAKELP_SIMPLE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference5 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.TALLDEEPSEAKELP_SIMPLE);
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> reference6 = registryEntryLookup.getOrThrow(ModOceanConfiguredFeatures.ASCOMYCOTA_SIMPLE);
        PlacedFeatures.register(featureRegisterable, ASCOMYCOTA, reference, seagrassModifiers(80));
        PlacedFeatures.register(featureRegisterable, TDSKP, reference3, seagrassModifiers(80));
        PlacedFeatures.register(featureRegisterable, SDSKP, reference2, seagrassModifiers(80));
        PlacedFeatures.register(
                featureRegisterable,
                ASCOMYCOTA,
                reference5,
                CarvingMaskPlacementModifier.of(GenerationStep.Carver.LIQUID),
                RarityFilterPlacementModifier.of(15),
                BlockFilterPlacementModifier.of(
                        BlockPredicate.allOf(
                                BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.STONE),
                                BlockPredicate.matchingBlocks(BlockPos.ORIGIN, Blocks.WATER),
                                BlockPredicate.matchingBlocks(Direction.UP.getVector(), Blocks.WATER)
                        )
                ),
                BiomePlacementModifier.of()
        );


    }
}
