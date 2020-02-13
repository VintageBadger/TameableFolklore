package com.vintagebadger.tameablefolklore;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;


public class TFEntities {

	public static EntityType<?> CHARLIE_ENTITY;
	
	public static void registerEntitySpawnEgg(EntityType<?> type, int color1, int color2) {
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().maxStackSize(64));
	}
	
}
