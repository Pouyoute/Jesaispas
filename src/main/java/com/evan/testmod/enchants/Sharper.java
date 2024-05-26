package com.evan.testmod.enchants;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

import java.awt.print.Book;

public class Sharper extends Enchantment {
    protected Sharper(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }


    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        return (float)(3.0 * (level/2));
    }

    @Override
    public @NotNull Component getFullname(int pLevel) {
        return ((MutableComponent) super.getFullname(pLevel)).withStyle(ChatFormatting.DARK_PURPLE);
    }


    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.canPerformAction(ToolActions.AXE_DIG) || super.canApplyAtEnchantingTable(stack);
    }

    @Override
    public int getMinCost(int pLevel) {
        return 1 + (pLevel - 2) * 15;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof DamageEnchantment);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return super.isAllowedOnBooks();
    }

    public static final EquipmentSlot[] slots = { EquipmentSlot.MAINHAND };
}
