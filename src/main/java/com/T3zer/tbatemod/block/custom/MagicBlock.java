package com.T3zer.tbatemod.block.custom;

import com.T3zer.tbatemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.fml.common.Mod;

public class MagicBlock extends Block{

    // Create the function block
    public MagicBlock(Properties properties){
        super(properties);


    }

    // Make the dedicated sound when the player hit wright click on the block
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1f,1f);
        return InteractionResult.SUCCESS;
    }

    //Detected if a player/Item is on the block
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        // if an entity is on the block : enter in loop
        if(entity instanceof ItemEntity itemEntity){
            //if the item on the block is a rawmythril block : enter in loop
            if(itemEntity.getItem().getItem() == ModItems.RAW_MYTHRIL.get()){
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }
            // Same for Diamond
            if(itemEntity.getItem().getItem() == Items.DANDELION){
                itemEntity.setItem(new ItemStack(Items.WITHER_ROSE, itemEntity.getItem().getCount()));
            }
            // ... Same for Skeleton skull dumbass :)
            if(itemEntity.getItem().getItem() == Items.SKELETON_SKULL){
                itemEntity.setItem(new ItemStack(Items.WITHER_SKELETON_SKULL, itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}


