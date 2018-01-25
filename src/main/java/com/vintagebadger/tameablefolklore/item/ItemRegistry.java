///////////////////////////////////////////////////////////////////
// ItemRegistry is based off of MatrexsVigil's ItemRegistry.java
//
///////////////////////////////////////////////////////////////////

package com.vintagebadger.tameablefolklore.item;

import static com.vintagebadger.tameablefolklore.TameableFolklore.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public final class ItemRegistry{
	public static final List<Item> itemlist = new ArrayList<Item>();
    public static final HashMap<String, Item> items = new HashMap<String, Item>();
	
    public static final HashSet<Item> allFood = new HashSet<Item>();
    
    //Items
    public static Item silvercarrotItem;
    
    
    public static boolean initialized = false;
    
    public static void registerItems(){
    	registerFoodItems();
    	initialized = true;
    }
    
    public static void registerFoodItems(){
    	silvercarrotItem = registerItemFood("silvercarrotitem", 4, config.mealsaturation);	
    }
    
    private static Item registerItemFood(String registryName, int amount, float saturation) {
		final Item item = new ItemTFFood(amount, saturation);
		allFood.add(item);

		return registerItem(item, registryName);
	}
    
    public static Item registerItem(Item item, String registryName) {
        item.setCreativeTab(TameableFolklore.modTab);
        item.setRegistryName(registryName);
        item.setUnlocalizedName(registryName);
        itemlist.add(item);
        return item;
    }
    
    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> reg = e.getRegistry();
        reg.registerAll(itemlist.toArray(new Item[0]));
        GeneralOreRegistry.initOreRegistry();
    }
    
    
	
}