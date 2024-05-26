package com.evan.testmod.item.custom;

import com.evan.testmod.item.ModCreativeModTab;
import com.evan.testmod.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItem extends Item {
    public DowsingRodItem() {

        super(new Properties()
                .durability(10)
                .tab(ModCreativeModTab.TEST_TAB));
    }

    @Override
    public  int getItemEnchantability(ItemStack stack) { return 5; }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment == Enchantments.UNBREAKING;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide())
        {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++)
            {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow))
                {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }

            }

            if(!foundBlock){
                player.sendMessage(new TranslatableComponent("item.testmod.dowsing_rod.no_valuables"), player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player -> player.broadcastBreakEvent(player.getUsedItemHand())));
        return super.useOn(pContext);
    }



    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow)
    {
        player.sendMessage(new TextComponent("Found " +blockBelow.asItem().getRegistryName().toString() + " at "
        + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block)
    {
        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

        if(Screen.hasShiftDown())
        {
            pTooltipComponents.add(new TranslatableComponent("tooltip.testmod.dowsing_rod.tooltip.shift"));
        } else
        {
            pTooltipComponents.add(new TranslatableComponent("tooltip.testmod.dowsing_rod.tooltip"));
        }
    }
}
