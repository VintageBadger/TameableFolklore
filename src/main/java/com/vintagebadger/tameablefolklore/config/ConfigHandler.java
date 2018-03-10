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

    public final Configuration config;
    
    ///////////////////////////////////////////////
    //copied from Pam's Harvestcraft just to test if this works-- to be replaced
    /**
     * Defaults
     */
    private static final int defaultCropFoodRestore = 1;
    private static final double defaultSaturationSmall = 0.6D;
    private static final double defaultSaturationMeal = 1.2D;
    private static final double defaultSaturationMeatyMeal = 1.600000023841858D;
    private static final double defaultCropGrowthSpeed = 0.0D;
    private static final double defaultFruitGrowthSpeed = 0.0D;
    
    /**
     * Config
     */
    public float mealsaturation = 1.2f;
    public int cropfoodRestore = 1;
    public float cropsaturationRestore = 1.2f;
    
    
    //End copied from Pam's Harvestcraft
    ////////////////////////////////////////////////
    
    public ConfigHandler(Configuration config){
    	this.config = config;
    	initSettings();
    }
    
    private void initSettings(){
    	 config.load();
    	 
    	 //ADD THE INIT SETTINGS
    	 initGeneralSettings();
    	 
    	 if(config.hasChanged()){
    		 config.save();
    	 } 
    }
    
    private void initGeneralSettings(){
    	//TODO
    	
    }
    
}