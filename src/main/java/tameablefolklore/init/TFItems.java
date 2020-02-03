package tameablefolklore.init;

import tameablefolklore.TameableFolklore;
import net.minecraft.item.Item;
import net.minecraftforge.registries.*;

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
