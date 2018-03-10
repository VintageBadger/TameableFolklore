package com.vintagebadger.tameablefolklore.item;

import net.minecraft.item.ItemFood;

public class ItemSilverCarrot extends ItemFood{
	public ItemSilverCarrot(int amount, float saturation, boolean isWolfFood){
		super(amount, saturation, isWolfFood);
		setUnlocalizedName("silver_carrot");
		setRegistryName("itemsilvercarrot");
	}
}
