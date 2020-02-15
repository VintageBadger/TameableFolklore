package com.vintagebadger.tameablefolklore;

import org.apache.logging.log4j.Logger;

import com.vintagebadger.tameablefolklore.init.TFEntities;
import com.vintagebadger.tameablefolklore.init.TFItems;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TFRegistries {
	public static final ItemGroup TAMEABLEFOLKLORE = TameableFolklore.TAMEABLEFOLKLORE;
	public static final Logger LOGGER = TameableFolklore.LOGGER;
	public static final String MODID = TameableFolklore.MODID;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				TFItems.charlie_spawn_egg = new Item(new Item.Properties().group(TAMEABLEFOLKLORE)).setRegistryName(location("charlie_spawn_egg"))
				);
		TFEntities.registerEntitySpawnEggs(event);
	}
	/***
	 * Cleans up the item registry listings
	 * Associates items with the mod name
	 */
	public static ResourceLocation location(String name) {
		return new ResourceLocation(MODID, name);
	}

	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
			TFEntities.CHARLIE_ENTITY
		);
		
		TFEntities.registerEntityWorldSpawns();
	}

}
