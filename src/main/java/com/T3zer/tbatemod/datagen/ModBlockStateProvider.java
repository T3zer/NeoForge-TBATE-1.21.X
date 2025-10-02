package com.T3zer.tbatemod.datagen;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
