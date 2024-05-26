package com.evan.testmod.item.custom;

import com.evan.testmod.item.ModCreativeModTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class TestFuelItem extends Item {
    public TestFuelItem() {
        super(new Properties()
                .stacksTo(64)
                .tab(ModCreativeModTab.TEST_TAB));
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 3200;
    }
}
