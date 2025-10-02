package com.T3zer.tbatemod.datagen;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}