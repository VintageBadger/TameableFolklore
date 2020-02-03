package tameablefolklore;

import tameablefolklore.config.ConfigHandler;
import tameablefolklore.init.TFItems;
import tameablefolklore.proxy.CommonProxy;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TameableFolklore.MODID)

public class TameableFolklore {
	public static final String MODID = "tameablefolklore";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public TameableFolklore() {
		LOGGER.debug("Tameable Folklore Main");
		
		
		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register Deferred Registers (Does not need to be before Configs)
		ModBlocks.BLOCKS.register(modEventBus);
		TFItems.ITEMS.register(modEventBus);
		ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		// Register Configs (Does not need to be after Deferred Registers)
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ConfigHolder.CLIENT_SPEC);
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);
	}
	
}


