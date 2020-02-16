package com.vintagebadger.tameablefolklore;

import org.apache.logging.log4j.Logger;

import com.vintagebadger.tameablefolklore.init.TFEntities;
import com.vintagebadger.tameablefolklore.init.TFItems;
import com.vintagebadger.tameablefolklore.item.ModdedSpawnEggItem;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TFRegistries {
	//public static final ItemGroup TAMEABLEFOLKLORE = TameableFolklore.TAMEABLEFOLKLORE;
	public static final Logger LOGGER = TameableFolklore.LOGGER;
	public static final String MODID = TameableFolklore.MODID;

	/*
	 * @SubscribeEvent public static void registerItems(final
	 * RegistryEvent.Register<Item> event) { event.getRegistry().registerAll(
	 * TFItems.charlie_spawn_egg = new Item(new
	 * Item.Properties().group(TAMEABLEFOLKLORE)).setRegistryName(location(
	 * "charlie_spawn_egg")) ); TFEntities.registerEntitySpawnEggs(event); }
	 */
	/***
	 * Cleans up the item registry listings
	 * Associates items with the mod name
	 */
	/*
	 * public static ResourceLocation location(String name) { return new
	 * ResourceLocation(MODID, name); }
	 * 
	 * @SubscribeEvent public static void registerEntities(final
	 * RegistryEvent.Register<EntityType<?>> event) {
	 * event.getRegistry().registerAll( TFEntities.CHARLIE_ENTITY );
	 * 
	 * TFEntities.registerEntityWorldSpawns(); }
	 */
	
	/**
	 * Exists to work around a limitation with Spawn Eggs:
	 * Spawn Eggs require an EntityType, but EntityTypes are created AFTER Items.
	 * Therefore it is "impossible" for modded spawn eggs to exist.
	 * To get around this we have our own custom SpawnEggItem, but it needs
	 * some extra setup after Item and EntityType registration completes.
	 */
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onPostRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		ModdedSpawnEggItem.initUnaddedEggs();
	}

}
