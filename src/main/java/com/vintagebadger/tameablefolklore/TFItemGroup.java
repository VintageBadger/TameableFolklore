package com.vintagebadger.tameablefolklore;

import com.vintagebadger.tameablefolklore.lists.ItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TFItemGroup extends ItemGroup {

	public TFItemGroup() {
		super("tameablefolklore");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.charlie_spawn_egg);
	}

}
