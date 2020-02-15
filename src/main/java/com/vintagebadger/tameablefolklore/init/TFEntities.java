package com.vintagebadger.tameablefolklore.init;

import com.vintagebadger.tameablefolklore.TFItemGroup;
import com.vintagebadger.tameablefolklore.TFRegistries;
import com.vintagebadger.tameablefolklore.entities.CharlieEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;


public class TFEntities {
	
	public static EntityType<?> CHARLIE_ENTITY = EntityType.Builder.create(CharlieEntity::new, EntityClassification.CREATURE).build(TFRegistries.MODID + ":charlie_entity").setRegistryName(TFRegistries.location("charlie_entity"));
	
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				TFItems.charlie_spawn_egg = registerEntitySpawnEgg(CHARLIE_ENTITY, 0xFBD051, 0xD39E53, "charlie_spawn_egg")
				);
	}
	
	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(CHARLIE_ENTITY, Biomes.PLAINS, Biomes.JUNGLE, Biomes.FOREST);
	}
	
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(TFRegistries.TAMEABLEFOLKLORE));
		item.setRegistryName(TFRegistries.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome... biomes) {
		for(Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}
	
}
