package harak.deepocean.block;

import harak.deepocean.HaraksDeepOceans;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SeagrassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ABYSSROCK = registerBlock("abyssrock", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block ABYSSQUARTS = registerBlock("abyssquarts", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block ABYSSALBRICKS = registerBlock("abyssalbricks", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block CRACKEDABYSSALBRICKS = registerBlock("crackedabyssalbricks", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block PALEABYSSROCK = registerBlock("paleabyssrock", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block GLOWINGCORAL = registerBlock("glowingcoral", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block MUDDYABYSSROCK = registerBlock("muddyabyssrock", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block SHORTDEEPSEAGRASS = registerBlock("shortdeepseagrass", new SeagrassBlock(FabricBlockSettings.copyOf(Blocks.SEAGRASS).luminance(7).noCollision()));
    public static final Block TALLDEEPSEAGRASS = registerBlock("talldeepseagrass", new SeagrassBlock(FabricBlockSettings.copyOf(Blocks.SEAGRASS).luminance(8).noCollision()));
    public static final Block ASCOMYCOTA = registerBlock("ascomycota", new SeagrassBlock(FabricBlockSettings.copyOf(Blocks.SEAGRASS).luminance(8).noCollision()));
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
