package harak.deepocean.datagen;

import harak.deepocean.ModBlocks;
import harak.deepocean.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.HARDSTONE);
        // addDrop(ModBlocks.ORE, oreDrops(ModBlocks.ORE, ModItems.RAW));
    }
}
