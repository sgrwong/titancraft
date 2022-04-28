package com.titan.titancraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SteelTitanEntity extends TitanEntity {
	protected SteelTitanEntity(EntityType<? extends PathfinderMob> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
		explosionStrength = 0;
		shootCharge = 5;
	}

	@Override
	protected ResourceLocation getDefaultLootTable() {
		return new ResourceLocation(TitanCraft.MODID, "entities/titan");
	}

	//Set attributes such as speed, health for the titan
	public static AttributeSupplier.Builder createAttributes(float movementSpeed) {
		AttributeSupplier.Builder attributes = Mob.createMobAttributes();
		attributes = attributes.add(Attributes.MOVEMENT_SPEED, movementSpeed);
		attributes = attributes.add(Attributes.MAX_HEALTH, 60);
		attributes = attributes.add(Attributes.ARMOR, 5);
		attributes = attributes.add(Attributes.ATTACK_DAMAGE, 30);
		return attributes;
	}
}
