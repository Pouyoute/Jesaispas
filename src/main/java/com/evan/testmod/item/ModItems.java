package com.evan.testmod.item;

import com.evan.testmod.TestMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> TESTIUM = ITEMS.register("testium",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DEESSE = ITEMS.register("deesse",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).food(ModFoods.DEESSE)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
