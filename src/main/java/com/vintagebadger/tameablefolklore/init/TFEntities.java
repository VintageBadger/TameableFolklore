package com.vintagebadger.tameablefolklore.init;

import com.vintagebadger.tameablefolklore.TFItemGroups;
import com.vintagebadger.tameablefolklore.TFRegistries;
import com.vintagebadger.tameablefolklore.TameableFolklore;
import com.vintagebadger.tameablefolklore.entities.CharlieEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class TFEntities {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, TameableFolklore.MODID);

	public static final String CHARLIE_ENTITY_NAME = "charlie_entity"; 
	public static final RegistryObject<EntityType<CharlieEntity>> CHARLIE_ENTITY = ENTITY_TYPES.register(CHARLIE_ENTITY_NAME, () ->
		EntityType.Builder.<CharlieEntity>create(CharlieEntity::new, EntityClassification.CREATURE).build(TFRegistries.MODID +":charlie_entity"));

}
