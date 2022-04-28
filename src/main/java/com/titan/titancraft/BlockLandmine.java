package com.titan.titancraft;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class BlockLandmine extends Block {

    public BlockLandmine() {
        super(BlockBehaviour.Properties
                .of(Material.EXPLOSIVE, MaterialColor.COLOR_ORANGE)
                .strength(2.0f, 6.0f)
                .instabreak());
                //.noDrops());
    }

    private void explode(Level level, BlockPos pos) { //create an explosion in level at pos
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4F, Explosion.BlockInteraction.BREAK);
    }

    //explode when stepped on
    @ParametersAreNonnullByDefault
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        explode(level, blockPos);
    }


    @Override
    public void wasExploded(Level level, BlockPos blockPos, Explosion explosion) {
        //if the source explosion is not the current block then explode
        if (!(explosion.getPosition().x == blockPos.getX() && explosion.getPosition().y == blockPos.getY() && explosion.getPosition().z == blockPos.getZ())) {
            explode(level, blockPos);
        }
    }
}
