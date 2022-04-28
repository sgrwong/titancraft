package com.titan.titancraft;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class TitanFireball extends SmallFireball {

    private final float power;

    public TitanFireball(Level level, double z, double y, double z1, double x, double y1, double z2, float explosionPower) {
        super(level, z, y, z1, x, y1, z2);
        power = explosionPower;
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        var location = hitResult.getLocation();
        level.explode(null, location.x, location.y, location.z, power, Explosion.BlockInteraction.BREAK);
    }
}
