package harak.deepocean.world.biome;

import harak.deepocean.HaraksDeepOceans;
import harak.deepocean.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized(){
        Regions.register(new ModOverworldRegion(new Identifier(HaraksDeepOceans.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, HaraksDeepOceans.MOD_ID, ModMaterialRules.createModSurfaceRule());

    }
}
