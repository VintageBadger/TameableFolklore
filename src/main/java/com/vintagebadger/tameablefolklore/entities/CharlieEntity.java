package com.vintagebadger.tameablefolklore.entities;

import java.util.function.Predicate;

import com.vintagebadger.tameablefolklore.init.TFEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BegGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.CatLieOnBedGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.ai.goal.OcelotAttackGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;

public class CharlieEntity extends CatEntity{
	private static final Ingredient BREEDING_ITEMS = Ingredient.fromItems(Items.COD, Items.SALMON);
	private static final DataParameter<Integer> COLLAR_COLOR = EntityDataManager.createKey(CatEntity.class, DataSerializers.VARINT);
	public static final Predicate<LivingEntity> field_213441_bD = (p_213440_0_) -> {
	      EntityType<?> entitytype = p_213440_0_.getType();
	      return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
	   };

	public CharlieEntity(final EntityType<? extends CatEntity> type, World worldIn) 
	{
		super(type, worldIn);
		this.setTamed(true);
	}

	@Override
	protected void registerGoals()
	{
		this.sitGoal = new SitGoal(this);
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, this.sitGoal);
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
		this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, field_213441_bD));
		this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, TurtleEntity.class, false, TurtleEntity.TARGET_DRY_BABY));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
		/*
		 * this.sitGoal = new SitGoal(this); this.goalSelector.addGoal(0, new
		 * SwimGoal(this)); this.goalSelector.addGoal(1, this.sitGoal);
		 * this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		 * this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.0D, 10.0F, 5.0F,
		 * false)); //entity, followSpeed, minDistance, maxDistance, false?
		 * this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this,
		 * AbstractSkeletonEntity.class, false));
		 */

	}

	@Override
	protected void registerAttributes() 
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
		/*
		 * this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		 * this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE)
		 * .setBaseValue(2.0D);
		 */
	}

	@Override
	public void setTamed(boolean tamed) {
		super.setTamed(tamed);
		if (tamed) {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
			this.setHealth(20.0F);
		} else {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		}

		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}






	/**
	@SuppressWarnings("unchecked")
	protected CharlieEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super((EntityType<? extends TameableEntity>) TFEntities.CHARLIE_ENTITY, worldIn);
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void registerGoals() {
		this.sitGoal = new SitGoal(this);
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1.2));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.0D, 10.0F, 5.0F, false));
		this.goalSelector.addGoal(8, new LeapAtTargetGoal(this, 0.3F));
		this.goalSelector.addGoal(9, new OcelotAttackGoal(this));
		this.goalSelector.addGoal(10, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(11, new WaterAvoidingRandomWalkingGoal(this, 0.8D, 1.0000001E-5F));
		this.goalSelector.addGoal(12, new LookAtGoal(this, PlayerEntity.class, 10.0F));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.0d);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}

	protected net.minecraft.util.SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_CAT_DEATH;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		// TODO Auto-generated method stub
		return super.attackEntityAsMob(entityIn);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return BREEDING_ITEMS.test(stack);
	}

	public boolean canDespawn(double distanceToClosestPlayer) {
		return !this.isTamed() && this.ticksExisted > 2400;
	}

	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			return super.processInteract(player, hand);
		} else if (this.world.isRemote) {
			return this.isTamed() && this.isOwner(player) || this.isBreedingItem(itemstack);
		} else {
			if (this.isTamed()) {
				if (this.isOwner(player)) {
					if (!(item instanceof DyeItem)) {
						if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(player, itemstack);
							this.heal((float)item.getFood().getHealing());
							return true;
						}

						boolean flag = super.processInteract(player, hand);
						if (!flag || this.isChild()) {
							this.sitGoal.setSitting(!this.isSitting());
						}

						return flag;
					}

					DyeColor dyecolor = ((DyeItem)item).getDyeColor();
					if (dyecolor != this.getCollarColor()) {
						this.setCollarColor(dyecolor);
						if (!player.abilities.isCreativeMode) {
							itemstack.shrink(1);
						}

						this.enablePersistence();
						return true;
					}
				}
			} else if (this.isBreedingItem(itemstack)) {
				this.consumeItemFromStack(player, itemstack);
				if (this.rand.nextInt(3) == 0) {
					this.setTamedBy(player);
					this.sitGoal.setSitting(true);
					this.world.setEntityState(this, (byte)7);
				} else {
					this.world.setEntityState(this, (byte)6);
				}

				this.enablePersistence();
				return true;
			}

			boolean flag1 = super.processInteract(player, hand);
			if (flag1) {
				this.enablePersistence();
			}

			return flag1;
		}
	}
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putByte("CollarColor", (byte)this.getCollarColor().getId());
	}
	public DyeColor getCollarColor() {
		return DyeColor.byId(this.dataManager.get(COLLAR_COLOR));
	}
	public void setCollarColor(DyeColor p_213417_1_) {
		this.dataManager.set(COLLAR_COLOR, p_213417_1_.getId());
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(COLLAR_COLOR, DyeColor.RED.getId());
	}
	 **/
}
