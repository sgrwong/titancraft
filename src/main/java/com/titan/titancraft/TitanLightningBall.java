package com.titan.titancraft;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class TitanLightningBall extends SmallFireball {
    public TitanLightningBall(Level level, double z, double y, double z1, double x, double y1, double z2) {
        super(level, z, y, z1, x, y1, z2);
        super.setInvisible(true);
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        var location = hitResult.getLocation();
        var lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
        lightningBolt.setPos(location);
        level.addFreshEntity(lightningBolt);
    }
}
