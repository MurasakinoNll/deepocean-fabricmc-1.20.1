package harak.deepocean.datagen;

import harak.deepocean.block.ModBlocks;
import harak.deepocean.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSSROCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSSQUARTZ);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSSALBRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKEDABYSSALBRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PALEABYSSROCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLOWINGCORAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MUDDYABYSSROCK);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SHORTDEEPSEAKELP, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TALLDEEPSEAKELP, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ASCOMYCOTA, BlockStateModelGenerator.TintType.TINTED);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.URCHIN_FLAIL, Models.GENERATED);
    }
}
