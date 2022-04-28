package com.titan.titancraft;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SteelTitanRenderer<Type extends SteelTitanEntity> extends MobRenderer<Type, SteelTitanModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TitanCraft.MODID, "textures/entities/titan.png");

    public SteelTitanRenderer(EntityRendererProvider.Context context) {
        super(context, new SteelTitanModel<>(context.bakeLayer(SteelTitanModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SteelTitanEntity p_114482_) {
        return TEXTURE;
    }
}
