package tameablefolklore.init;

import tameablefolklore.item.ItemSilverCarrot;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class TFItems {
	public static Item silver_carrot;
	
	public static void init(){
		silver_carrot = new ItemSilverCarrot(2, 1.0f, false);
	}
	
	public static void register(){
		registerItem(silver_carrot);
	}
	
	public static void registerItem(Item item){
		ForgeRegistries.ITEMS.register(item);
	}
	
	public static void registerRenders(){
		registerRender(silver_carrot);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
