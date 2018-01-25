package com.vintagebadger.tameablefolklore.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vintagebadger.tameablefolklore.TameableFolklore;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ConfigHandler {

    private final Configuration config;
    
    public ConfigHandler(Configuration config){
    	this.config = config;
    	initSettings();
    }
    
    private void initSettings(){
    	 
    }
    
}