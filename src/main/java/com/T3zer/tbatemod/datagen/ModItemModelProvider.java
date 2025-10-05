package com.T3zer.tbatemod.datagen;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.block.ModBlocks;
import com.T3zer.tbatemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TbateMod.MOD_ID, existingFileHelper);

    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.MYTHRIL.get());
        basicItem(ModItems.RAW_MYTHRIL.get());

        basicItem(ModItems.RADISH.get());

        basicItem(ModItems.MYSTERIOUS_EGG.get());

        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());

        basicItem(ModItems.CHISEL.get());

        buttonItem(ModBlocks.MYTHRIL_BUTTON, ModBlocks.MYTHRIL_BLOCK);
        fenceItem(ModBlocks.MYTHRIL_FENCE, ModBlocks.MYTHRIL_BLOCK);
        wallItem(ModBlocks.MYTHRIL_WALL, ModBlocks.MYTHRIL_BLOCK);

        basicItem(ModBlocks.MYTHRIL_DOOR.asItem());

        handheldItem(ModItems.MYTHRIL_SWORD);
        handheldItem(ModItems.MYTHRIL_PICKAXE);
        handheldItem(ModItems.MYTHRIL_AXE);
        handheldItem(ModItems.MYTHRIL_SHOVEL);
        handheldItem(ModItems.MYTHRIL_HOE);
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TbateMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TbateMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(TbateMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }


    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TbateMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}