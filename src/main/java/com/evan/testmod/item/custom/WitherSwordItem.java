package com.evan.testmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;

public class WitherSwordItem extends SwordItem {
    public WitherSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1), pAttacker);
        pAttacker.addEffect(new MobEffectInstance(new MobEffectInstance(MobEffects.REGENERATION, 100, 1)));

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.getCooldowns().addCooldown(this, 120);
        if(pLevel.isClientSide())
        {
            Item sword = pPlayer.getItemInHand(InteractionHand.MAIN_HAND).getItem();
            if(pUsedHand == InteractionHand.MAIN_HAND)
            {
                pPlayer.playSound(SoundType.AMETHYST.getPlaceSound(), 100f, 1f);

            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
