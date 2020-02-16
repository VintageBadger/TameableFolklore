package com.vintagebadger.tameablefolklore.client.render;

import com.vintagebadger.tameablefolklore.TFRegistries;
import com.vintagebadger.tameablefolklore.TameableFolklore;
import com.vintagebadger.tameablefolklore.client.models.CharlieEntityModel;
import com.vintagebadger.tameablefolklore.entities.CharlieEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CharlieEntityRender extends LivingRenderer<CharlieEntity, CharlieEntityModel>{

	public CharlieEntityRender(EntityRendererManager manager) {
		super(manager, new CharlieEntityModel(0), 0f);
	}

	@Override
	public ResourceLocation getEntityTexture(CharlieEntity entity) {
		return new ResourceLocation(TameableFolklore.MODID,"textures/entity/charlie_entity.png");
	}

	
	public static class RenderFactory implements IRenderFactory<CharlieEntity>{

		@Override
		public EntityRenderer<? super CharlieEntity> createRenderFor(EntityRendererManager manager) {
			return new CharlieEntityRender(manager);
		}
		
	}
}
