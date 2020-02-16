package com.vintagebadger.tameablefolklore;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vintagebadger.tameablefolklore.client.render.TFRenderRegistry;
import com.vintagebadger.tameablefolklore.init.TFEntities;
import com.vintagebadger.tameablefolklore.init.TFItems;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tameablefolklore")
public class TameableFolklore
{
    public static TameableFolklore instance;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "tameablefolklore";
    //public static final ItemGroup TAMEABLEFOLKLORE = new TFItemGroups();

    public TameableFolklore() {
    	instance = this;
    	
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        TFItems.ITEMS.register(modEventBus);
        TFEntities.ENTITY_TYPES.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        TFRenderRegistry.registerEntityRenders();
        LOGGER.info("clientRegistries method registered");
    }
    
}




















