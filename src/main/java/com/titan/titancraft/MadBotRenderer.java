package com.titan.titancraft;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MadBotRenderer<Type extends MadBotEntity> extends MobRenderer<Type, MadBotModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TitanCraft.MODID, "textures/entities/madbot.png");

    public MadBotRenderer(EntityRendererProvider.Context context) {
        super(context, new MadBotModel<>(context.bakeLayer(MadBotModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MadBotEntity p_114482_) {
        return TEXTURE;
    }
}
