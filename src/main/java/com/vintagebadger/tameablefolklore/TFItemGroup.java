package com.vintagebadger.tameablefolklore;

import com.vintagebadger.tameablefolklore.init.TFItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TFItemGroup extends ItemGroup {

	public TFItemGroup() {
		super("tameablefolklore");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(TFItems.charlie_spawn_egg);
	}

}
