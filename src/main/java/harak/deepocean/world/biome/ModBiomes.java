package harak.deepocean.world.biome;

import harak.deepocean.HaraksDeepOceans;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static RegistryKey<Biome> DEEPOCEAN = RegistryKey.of(RegistryKeys.BIOME, new Identifier(HaraksDeepOceans.MOD_ID, "deepocean"));

    public static void bootstrap(Registerable<Biome> context){
        context.register(DEEPOCEAN.deepoceanBiome(context));
    }
}
