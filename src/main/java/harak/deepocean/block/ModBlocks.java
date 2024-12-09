package harak.deepocean.block;

import harak.deepocean.HaraksDeepOceans;
import harak.deepocean.block.custom.DeepSeaKelp;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block HARDSTONE = registerBlock("hardstone",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block SHORTDEEPSEAKELP = registerBlock("shortdeepseakelp", new DeepSeaKelp(FabricBlockSettings.copyOf(Blocks.SEAGRASS).luminance(7)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(HaraksDeepOceans.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(HaraksDeepOceans.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        HaraksDeepOceans.LOGGER.info("registering blocks");
    }
}
