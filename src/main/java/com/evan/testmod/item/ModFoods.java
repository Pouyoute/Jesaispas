package com.evan.testmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.registries.DeferredRegister;

public class ModFoods {

    public static final FoodProperties DEESSE = (new FoodProperties.Builder())
            .nutrition(1)
            .saturationMod(0.3F)
            .effect(new MobEffectInstance(MobEffects.HUNGER, 120, 5), 1)
            .effect(new MobEffectInstance(MobEffects.HARM, 1, 10), 0.5f)
            .build();
}
