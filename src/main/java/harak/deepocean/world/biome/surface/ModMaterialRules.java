package harak.deepocean.world.biome.surface;

import harak.deepocean.block.ModBlocks;
import harak.deepocean.world.biome.ModBiomes;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {

    public static net.minecraft.world.gen.surfacebuilder.MaterialRules.MaterialRule createModSurfaceRule() {
        return net.minecraft.world.gen.surfacebuilder.MaterialRules.sequence(
                 MaterialRules.condition(
                     MaterialRules.biome(ModBiomes.DEEPOCEAN),
                     MaterialRules.block(ModBlocks.ABYSSROCK.getDefaultState())
                         
                 )

        );
    }
}