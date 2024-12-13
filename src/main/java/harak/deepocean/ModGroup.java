package harak.deepocean;



import harak.deepocean.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModGroup {
  public static final ItemGroup DEEPOCEAN_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(HaraksDeepOceans.MOD_ID, "abyss"),
          FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.GLOWINGCORAL))
                  .displayName(Text.literal("Deep Oceans"))
                  .entries(((displayContext, entries) -> {
                      entries.add(ModBlocks.ABYSSROCK);
                      entries.add(ModBlocks.ABYSSQUARTS);
                      entries.add(ModBlocks.ABYSSALBRICKS);
                      entries.add(ModBlocks.CRACKEDABYSSALBRICKS);
                      entries.add(ModBlocks.TALLDEEPSEAGRASS);
                      entries.add(ModBlocks.PALEABYSSROCK);
                      entries.add(ModBlocks.GLOWINGCORAL);
                      entries.add(ModBlocks.MUDDYABYSSROCK);
                      entries.add(ModBlocks.SHORTDEEPSEAGRASS);
                      entries.add(ModBlocks.ASCOMYCOTA);
                  }))
                  .build());
    public static void registerGroups() {

    }
}
