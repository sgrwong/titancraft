package com.titan.titancraft;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AluminiumTitanRenderer<Type extends AluminiumTitanEntity> extends MobRenderer<Type, AluminiumTitanModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(TitanCraft.MODID, "textures/entities/aluminiumtitan.png");

    public AluminiumTitanRenderer(EntityRendererProvider.Context context) {
        super(context, new AluminiumTitanModel<>(context.bakeLayer(AluminiumTitanModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(AluminiumTitanEntity p_114482_) {
        return TEXTURE;
    }
}
