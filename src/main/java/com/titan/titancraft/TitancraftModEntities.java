package com.titan.titancraft;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TitancraftModEntities {
	private static final List<EntityType<?>> REGISTRY = new ArrayList<>();
	public static final EntityType<SteelTitanEntity> TITAN = register("titan",
			EntityType.Builder.of(SteelTitanEntity::new, MobCategory.CREATURE).sized(0.5f, 1.9f));

	public static final EntityType<AluminiumTitanEntity> ALUMINIUM_TITAN = register("aluminium_titan",
			EntityType.Builder.of(AluminiumTitanEntity::new, MobCategory.CREATURE).sized(0.5f, 1.9f));

	public static final EntityType<TitaniumTitanEntity> TITANIUM_TITAN = register("titanium_titan",
			EntityType.Builder.of(TitaniumTitanEntity::new, MobCategory.CREATURE).sized(0.5f, 1.9f));

	public static final EntityType<MadBotEntity> MAD_BOT = register("madbot",
			EntityType.Builder.of(MadBotEntity::new, MobCategory.CREATURE).sized(0.5f,1.9f));

	private static <T extends Entity> EntityType<T> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		EntityType<T> entityType = (EntityType<T>) entityTypeBuilder.build(registryname).setRegistryName(registryname);
		REGISTRY.add(entityType);
		return entityType;
	}

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new EntityType[0]));
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TITAN, SteelTitanEntity.createAttributes(0.1F).build());
		event.put(ALUMINIUM_TITAN, AluminiumTitanEntity.createAttributes(0.3F).build());
		event.put(TITANIUM_TITAN, TitaniumTitanEntity.createAttributes(0.2F).build());
		event.put(MAD_BOT, MadBotEntity.createAttributes().build());
	}
}
