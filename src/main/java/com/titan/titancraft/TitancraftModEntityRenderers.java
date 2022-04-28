package com.titan.titancraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TitancraftModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TitancraftModEntities.TITAN, SteelTitanRenderer::new);
		event.registerEntityRenderer(TitancraftModEntities.ALUMINIUM_TITAN, AluminiumTitanRenderer::new);
		event.registerEntityRenderer(TitancraftModEntities.TITANIUM_TITAN, TitaniumTitanRenderer::new);
		event.registerEntityRenderer(TitancraftModEntities.MAD_BOT, MadBotRenderer::new);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(SteelTitanModel.LAYER_LOCATION, SteelTitanModel::createBodyLayer);
		event.registerLayerDefinition(AluminiumTitanModel.LAYER_LOCATION, AluminiumTitanModel::createBodyLayer);
		event.registerLayerDefinition(TitaniumTitanModel.LAYER_LOCATION, TitaniumTitanModel::createBodyLayer);
		event.registerLayerDefinition(MadBotModel.LAYER_LOCATION, MadBotModel::createBodyLayer);
	}
}
