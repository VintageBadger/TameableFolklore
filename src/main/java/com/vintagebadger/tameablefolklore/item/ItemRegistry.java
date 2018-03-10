package com.vintagebadger.tameablefolklore.item;

import java.util.*;
import com.vintagebadger.tameablefolklore.config.ConfigHandler;

import net.minecraft.item.Item;

public class ItemRegistry {
	public static final List<Item> itemlist = new ArrayList<Item>();
    public static final HashMap<String, Item> items = new HashMap<String, Item>();

	public static final HashSet<Item> allFishRaw = new HashSet<Item>();
	public static final HashSet<Item> allFood = new HashSet<Item>();
	public static final HashSet<Item> allJuice = new HashSet<Item>();

//Items
	public static Item ItemSilverCarrot;
	
	public static boolean initialized = false;
	
	public static void registerItems(){
		registerFoodItems();
		
		initialized = true;
	}
	private static void registerFoodItems(){
		//ItemSilverCarrot =  registerItemFood("ItemSilverCarrot", config.cropfoodRestore, config.cropsaturationRestore);
	}


}
