package com.evan.testmod.item;

import com.evan.testmod.TestMod;
import com.evan.testmod.item.custom.DowsingRodItem;
import com.evan.testmod.item.custom.ModArmorMaterial;
import com.evan.testmod.item.custom.TestFuelItem;
import com.evan.testmod.item.custom.WitherSwordItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> TESTIUM = ITEMS.register("testium",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEST_TAB)));

    public static final RegistryObject<Item> DEESSE = ITEMS.register("deesse",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEST_TAB).food(ModFoods.DEESSE)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem());

    public static final RegistryObject<Item> TEST_FUEL = ITEMS.register("test_fuel",
            () -> new TestFuelItem());

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.TEST_TAB).fireResistant()));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new WitherSwordItem(ModTiers.RUBY, 8, 3f,
                    new Item.Properties()
                    .fireResistant()
                    .tab(ModCreativeModTab.TEST_TAB)));

    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModTiers.RUBY, 2, 5f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(ModCreativeModTab.TEST_TAB)));

    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModTiers.RUBY, 10, 5f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(ModCreativeModTab.TEST_TAB)));

    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModTiers.RUBY, 2, 5f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(ModCreativeModTab.TEST_TAB)));

    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModTiers.RUBY, 0, 5f,
                    new Item.Properties()
                            .fireResistant()
                            .tab(ModCreativeModTab.TEST_TAB)));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.HEAD,
                    new Item.Properties()
                            .fireResistant()
                            .tab(ModCreativeModTab.TEST_TAB)));

    public static final RegistryObject<Item> RUBY_CHEST = ITEMS.register("ruby_chest",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.CHEST,
                    new Item.Properties()
                            .fireResistant()
                            .tab(ModCreativeModTab.TEST_TAB)));
    public static final RegistryObject<Item> RUBY_LEGS = ITEMS.register("ruby_legs",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.LEGS,
                    new Item.Properties()
                            .fireResistant()
                            .tab(ModCreativeModTab.TEST_TAB)));

    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.FEET,
                    new Item.Properties()
                            .fireResistant()
                            .tab(ModCreativeModTab.TEST_TAB)));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
