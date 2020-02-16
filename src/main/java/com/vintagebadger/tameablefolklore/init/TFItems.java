package com.vintagebadger.tameablefolklore.init;

import com.vintagebadger.tameablefolklore.TFItemGroups;
import com.vintagebadger.tameablefolklore.TameableFolklore;
import com.vintagebadger.tameablefolklore.item.ModdedSpawnEggItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TFItems {

	//public static Item charlie_spawn_egg;
	public static final DeferredRegister<Item> ITEMS =  new DeferredRegister<>(ForgeRegistries.ITEMS, TameableFolklore.MODID);
	
	public static final RegistryObject<ModdedSpawnEggItem> CHARLIE_SPAWN_EGG = ITEMS.register("charlie_spawn_egg", () -> new ModdedSpawnEggItem(TFEntities.CHARLIE_ENTITY, 0x0191C8, 0xE1BE33, new Item.Properties().group(TFItemGroups.TF_ITEM_GROUP)));
	public static final RegistryObject<Item> TREAT = ITEMS.register("treat", () -> new Item(new Item.Properties().group(TFItemGroups.TF_ITEM_GROUP)));
}
