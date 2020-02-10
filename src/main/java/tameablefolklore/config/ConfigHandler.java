package tameablefolklore.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tameablefolklore.TameableFolklore;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.config.ModConfig.Loading;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ConfigHandler {

    public final ModConfig config;
    
    
    public ConfigHandler(ModConfig config){
    	this.config = config;
    	//initSettings();
    }
    
/*    private void initSettings(){
    	 config.load();
    	 
    	 //ADD THE INIT SETTINGS
    	 initGeneralSettings();
    	 
    	 if(config.hasChanged()){
    		 config.save();
    	 } 
    } */
    
    private void initGeneralSettings(){
    	//TODO
    	
    }
    
}