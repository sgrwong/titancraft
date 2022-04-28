package com.titan.titancraft;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TitaniumTitanRenderer<Type extends TitaniumTitanEntity> extends MobRenderer<Type, TitaniumTitanModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TitanCraft.MODID, "textures/entities/titaniumtitan.png");

    public TitaniumTitanRenderer(EntityRendererProvider.Context context) {
        super(context, new TitaniumTitanModel<>(context.bakeLayer(TitaniumTitanModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TitaniumTitanEntity p_114482_) {
        return TEXTURE;
    }
}
