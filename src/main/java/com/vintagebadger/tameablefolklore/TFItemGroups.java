package com.vintagebadger.tameablefolklore;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import com.vintagebadger.tameablefolklore.init.TFItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class TFItemGroups{
	public static final ItemGroup TF_ITEM_GROUP = new TFItemGroup(TameableFolklore.MODID, () -> new ItemStack(TFItems.TREAT.get()));

	public static final class TFItemGroup extends ItemGroup{
		
		@Nonnull
		private final Supplier<ItemStack> iconSupplier;
		
		public TFItemGroup(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
			super(name);
			this.iconSupplier = iconSupplier;
		}
		
		@Override public ItemStack createIcon() { 
			return iconSupplier.get();
		}
	}


}
