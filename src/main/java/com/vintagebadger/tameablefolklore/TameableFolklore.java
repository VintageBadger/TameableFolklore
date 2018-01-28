package com.vintagebadger.tameablefolklore;

import com.vintagebadger.tameablefolklore.config.ConfigHandler;
//import com.vintagebadger.tameablefolklore.gui.GuiHandler;
import com.vintagebadger.tameablefolklore.item.ItemRegistry;
import com.vintagebadger.tameablefolklore.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)

public class TameableFolklore {
	
	@Instance(value = Reference.MODID)
	public static TameableFolklore instance = new TameableFolklore();
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs modTab = new CreativeTabs(Reference.MODID){
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem(){
			return new ItemStack(ItemRegistry.silvercarrotItem);
		}
	};
	
	public static ConfigHandler config;
	
	/*
	 * In this method read your config file, create Blocks, 
	 * Items, etc. and register them with the GameRegistry.
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		config = new ConfigHandler(new Configuration(event.getSuggestedConfigurationFile()));
		proxy.preInit(event);
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}
	
	/*
	 * In this method we can build up data structures, add 
	 * Crafting Recipes and register new handler.
	 */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	/*
	 * Its used to communicate with other mods and adjust 
	 * your setup based on this.
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
}


