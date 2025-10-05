package com.T3zer.tbatemod.datagen;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TbateMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MYTHRIL_BLOCK);

        blockWithItem(ModBlocks.MYTHRIL_ORE);
        blockWithItem(ModBlocks.MYTHRIL_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.MYTHRIL_STAIRS.get(), blockTexture(ModBlocks.MYTHRIL_BLOCK.get()));
        slabBlock(ModBlocks.MYTHRIL_SLAB.get(), blockTexture(ModBlocks.MYTHRIL_BLOCK.get()), blockTexture(ModBlocks.MYTHRIL_BLOCK.get()));

        buttonBlock(ModBlocks.MYTHRIL_BUTTON.get(), blockTexture(ModBlocks.MYTHRIL_BLOCK.get()));
        pressurePlateBlock(ModBlocks.MYTHRIL_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MYTHRIL_BLOCK.get()));

        fenceBlock(ModBlocks.MYTHRIL_FENCE.get(), blockTexture(ModBlocks.MYTHRIL_BLOCK.get()));
        fenceGateBlock(ModBlocks.MYTHRIL_FENCE_GATE.get(), blockTexture(ModBlocks.MYTHRIL_BLOCK.get()));
        wallBlock(ModBlocks.MYTHRIL_WALL.get(), blockTexture(ModBlocks.MYTHRIL_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.MYTHRIL_DOOR.get(), modLoc("block/mythril_door_bottom"), modLoc("block/mythril_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.MYTHRIL_TRAPDOOR.get(), modLoc("block/mythril_trapdoor"), true, "cutout");

        blockItem(ModBlocks.MYTHRIL_STAIRS);
        blockItem(ModBlocks.MYTHRIL_SLAB);
        blockItem(ModBlocks.MYTHRIL_PRESSURE_PLATE);
        blockItem(ModBlocks.MYTHRIL_FENCE_GATE);
        blockItem(ModBlocks.MYTHRIL_TRAPDOOR, "_bottom");

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tbatemodbytr:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tbatemodbytr:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
