package com.titan.titancraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TitaniumTitanEntity extends TitanEntity {

	protected TitaniumTitanEntity(EntityType<? extends PathfinderMob> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
		explosionStrength = 8;
		shootCharge = 100;
	}

	@Override
	protected ResourceLocation getDefaultLootTable() {
		return new ResourceLocation(TitanCraft.MODID, "entities/titaniumtitan");
	}

	//Set attributes such as speed, health for the titan
	public static AttributeSupplier.Builder createAttributes(float movementSpeed) {
		AttributeSupplier.Builder attributes = Mob.createMobAttributes();
		attributes = attributes.add(Attributes.MOVEMENT_SPEED, movementSpeed);
		attributes = attributes.add(Attributes.MAX_HEALTH, 30);
		attributes = attributes.add(Attributes.ARMOR, 5);
		attributes = attributes.add(Attributes.ATTACK_DAMAGE, 20);
		return attributes;
	}
}
