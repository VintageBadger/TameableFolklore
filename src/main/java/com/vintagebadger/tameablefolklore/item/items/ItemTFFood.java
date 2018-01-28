package com.vintagebadger.tameablefolklore.item.items;

import java.util.List;
import com.vintagebadger.tameablefolklore.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemTFFood extends ItemFood{
	public final float saturation;
	
	public ItemTFFood(int healAmount, float saturation){
		super(healAmount, saturation, false);
		this.saturation = saturation;
	}
	
}


