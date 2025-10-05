package com.T3zer.tbatemod.item.custom;


import com.T3zer.tbatemod.component.ModDataComponents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Map;
//creation of an item based on minecraft items
public class ChiselItem extends Item{
    private static final Map<Block, Block> CHISEL_MAP =
            //unchangable dictionnary of items who will change in another one
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.GOLD_BLOCK, Blocks.STONE

            );
    //call the item constructor to have basic item properties as durability, max stack...
    public ChiselItem(Properties properties){
        super(properties);

    }
    //execute when write click on a block with the item
    @Override
    public InteractionResult useOn(UseOnContext context) {
        //the world of the user
        Level level = context.getLevel();
        // the block who the user clicked on
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        //verify if the block is in the map and if we are server side
        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                //Make the chisel item loose 1 durabilty by hurting him
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                //play a sound
                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }
        }
        //return the result
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.tbatemod.chisel.shift_sown"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.tbatemod.chisel"));
        }

        if(stack.get(ModDataComponents.COORDINATES) != null){
            tooltipComponents.add(Component.literal("Last Block Change at " + stack.get(ModDataComponents.COORDINATES)));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
