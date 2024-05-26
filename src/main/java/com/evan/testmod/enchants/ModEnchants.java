package com.evan.testmod.enchants;

import com.evan.testmod.TestMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchants {

    public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TestMod.MOD_ID);


    public static final RegistryObject<Enchantment> SHARPER = ENCHANTS.register("sharper", () ->
        new Sharper(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, Sharper.slots)
    );



    public static void register(IEventBus eventbus) {ENCHANTS.register(eventbus); }
}


