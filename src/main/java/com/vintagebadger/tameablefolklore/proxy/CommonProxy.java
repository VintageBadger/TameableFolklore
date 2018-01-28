package com.vintagebadger.tameablefolklore.proxy;

import static com.vintagebadger.tameablefolklore.TameableFolklore.config;

import java.util.Set;

import com.vintagebadger.tameablefolklore.TameableFolklore;
import com.vintagebadger.tameablefolklore.item.ItemRegistry;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy{
	
	public void preInit(FMLPreInitializationEvent e){
		ItemRegistry.registerItems();
		MinecraftForge.EVENT_BUS.register(new ItemRegistry());
	}
	
	public void init(FMLInitializationEvent e){
		
	}
	
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
}


