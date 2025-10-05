package com.T3zer.tbatemod.datagen;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.item.ModItems;
import com.T3zer.tbatemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TbateMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.MYTHRIL.get())
                .add(ModItems.RAW_MYTHRIL.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.SWORDS)
                .add(ModItems.MYTHRIL_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.MYTHRIL_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.MYTHRIL_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.MYTHRIL_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.MYTHRIL_HOE.get());


    }
}
