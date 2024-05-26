package com.evan.testmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class explosiveBlockBlock extends Block {
    public explosiveBlockBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {


        if(!pLevel.isClientSide()) {
            if(pEntity instanceof LivingEntity)
            {

                pLevel.explode(null, pPos.getX(), pPos.getY()+2, pPos.getZ(), 25f, Explosion.BlockInteraction.BREAK);
            }
        }


        super.stepOn(pLevel, pPos, pState, pEntity);
    }

}
