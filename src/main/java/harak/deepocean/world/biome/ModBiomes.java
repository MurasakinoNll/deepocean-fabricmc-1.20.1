package harak.deepocean.world.biome;

import harak.deepocean.HaraksDeepOceans;
import harak.deepocean.world.ModPlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModBiomes {
    public static RegistryKey<Biome> DEEPOCEAN = RegistryKey.of(RegistryKeys.BIOME, new Identifier(HaraksDeepOceans.MOD_ID, "deepocean"));

    public static void bootstrap(Registerable<Biome> context){
        context.register(DEEPOCEAN, deepoceanBiome(context));
    }

    // Global generation adjustments for overworld can be configured here if needed
    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder, SpawnSettings.Builder spawnBuilder) {
        // Add any global modifications you want here
    }

    public static Biome deepoceanBiome (Registerable<Biome> context){
        RegistryEntryLookup<PlacedFeature> featureLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> carverLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        // Spawn settings builder for underwater mobs
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        // Use something akin to the deep lukewarm ocean as a baseline
        DefaultBiomeFeatures.addOceanMobs(spawnBuilder, 8, 4, 8);
        // Example: add salmon like cold/deep oceans
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 15, 1, 5));

        // Generation settings builder
        GenerationSettings.LookupBackedBuilder generationBuilder = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);
        addBasicFeatures(generationBuilder);
        DefaultBiomeFeatures.addDefaultOres(generationBuilder);
        DefaultBiomeFeatures.addDefaultDisks(generationBuilder);
        DefaultBiomeFeatures.addWaterBiomeOakTrees(generationBuilder);
        DefaultBiomeFeatures.addDefaultFlowers(generationBuilder);
        DefaultBiomeFeatures.addDefaultGrass(generationBuilder);
        DefaultBiomeFeatures.addDefaultMushrooms(generationBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(generationBuilder);

        // Add seagrass features typical for deep oceans
        generationBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_DEEP);
        generationBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ASCOMYCOTA);
        DefaultBiomeFeatures.addSeagrassOnStone(generationBuilder);

        DefaultBiomeFeatures.addKelp(generationBuilder);


        // Effects similar to a deep ocean: darker water, etc.
        BiomeEffects effects = new BiomeEffects.Builder()
                .waterColor(4159204) // typical ocean water color
                .waterFogColor(329011)
                .fogColor(12638463)
                .skyColor(getSkyColor(0.5F)) // Adjust as desired
                .moodSound(BiomeMoodSound.CAVE) // underwater ambient sound
                .build();

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.5F)
                .downfall(0.5F)
                .effects(effects)
                .spawnSettings(spawnBuilder.build())
                .generationSettings(generationBuilder.build())
                .build();
    }

    // If you have a helper method similar to vanilla's "addBasicFeatures", define it here
    // or import it from vanilla sources.
    private static void addBasicFeatures(GenerationSettings.LookupBackedBuilder generationBuilder) {
        // Add basic features such as lakes, springs, etc. if needed.
        // This would normally mirror what vanilla does for ocean biomes.

    }

    private static int getSkyColor(float temperature) {
        // Vanilla method for computing sky color from temperature:
        float f = temperature / 3.0F;
        f = Math.min(f, 1.0F);
        f = Math.max(f, -1.0F);
        return java.awt.Color.HSBtoRGB(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }
}
