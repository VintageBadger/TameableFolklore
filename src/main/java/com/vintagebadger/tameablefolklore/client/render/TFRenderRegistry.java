package com.vintagebadger.tameablefolklore.client.render;

import com.vintagebadger.tameablefolklore.entities.CharlieEntity;
import com.vintagebadger.tameablefolklore.init.TFEntities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class TFRenderRegistry {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(TFEntities.CHARLIE_ENTITY.get(), CharlieEntityRender::new);
	}
}
