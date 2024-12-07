package harak.deepocean;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(HaraksDeepOceans.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
    }
    public static final Item URCHIN_FLAIL = register(
            new Item(new Item.Settings()),
            "urchin_flail"
    );

    public static void initialize() {
    }
}
