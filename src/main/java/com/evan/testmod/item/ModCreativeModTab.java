package com.evan.testmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {

    public static final CreativeModeTab TEST_TAB = new CreativeModeTab("testmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DEESSE.get());
        }
    };
}
