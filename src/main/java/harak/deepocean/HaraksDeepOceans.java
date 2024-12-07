package harak.deepocean;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HaraksDeepOceans implements ModInitializer {
	public static final String MOD_ID = "haraks-deep-oceans";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello deep ocean");
	}
}