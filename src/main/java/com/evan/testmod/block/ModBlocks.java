package com.evan.testmod.block;

import com.evan.testmod.TestMod;
import com.evan.testmod.block.custom.explosiveBlockBlock;
import com.evan.testmod.item.ModCreativeModTab;
import com.evan.testmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static final RegistryObject<Block> MAZETTE = registerBlock("mazette_block",
                    () -> new Block(BlockBehaviour
                    .Properties.of(Material.METAL)
                    .strength(5f)
                    .requiresCorrectToolForDrops()),
            ModCreativeModTab.TEST_TAB);

    public static final RegistryObject<Block> explode = registerBlock("exploding_block",
            () -> new explosiveBlockBlock(BlockBehaviour
                    .Properties.of(Material.PLANT)
                    .strength(5f)
                    .requiresCorrectToolForDrops()),
                    ModCreativeModTab.TEST_TAB, "tooltip.testmod.block.explodind_block");

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(BlockBehaviour
                    .Properties.of(Material.STONE)
                    .strength(3f)
                    .sound(SoundType.STONE)
                    .explosionResistance(3)
                    .requiresCorrectToolForDrops()),
            ModCreativeModTab.TEST_TAB, true);

    public static final RegistryObject<Block> DEEP_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new Block(BlockBehaviour
                    .Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(4.5F)
                    .explosionResistance(5f)
                    .sound(SoundType.DEEPSLATE)),
                ModCreativeModTab.TEST_TAB);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour
                    .Properties.of(Material.METAL)
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(5f)
                    .sound(SoundType.METAL)),
            ModCreativeModTab.TEST_TAB, true);

    // CLASSIC REGISTERING
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }

    //REGISTERING WITH TOOLTIP
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, String toolTipKey)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, toolTipKey);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String toolTipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(toolTipKey));
            }
        });
    }

    //REGISTERING FIRE RES
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, boolean fireRes)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if(fireRes)
        {
            registerBlockItemFireRes(name, toReturn, tab);
        } else {
            registerBlockItem(name, toReturn, tab);
        }

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItemFireRes(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(tab).fireResistant()));
    }


    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

}
