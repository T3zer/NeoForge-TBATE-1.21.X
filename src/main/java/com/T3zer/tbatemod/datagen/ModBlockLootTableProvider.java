package com.T3zer.tbatemod.datagen;

import com.T3zer.tbatemod.block.ModBlocks;
import com.T3zer.tbatemod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.MYTHRIL_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get()); // or no loot table in MODBLOCKS class if wer don t wan t drop

        add(ModBlocks.MYTHRIL_ORE.get(),
                    block -> createOreDrop(ModBlocks.MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));
        add(ModBlocks.MYTHRIL_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.MYTHRIL_DEEPSLATE_ORE.get(), ModItems.RAW_MYTHRIL.get(),
                        2,5 ));

        dropSelf(ModBlocks.MYTHRIL_STAIRS.get());
        add(ModBlocks.MYTHRIL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MYTHRIL_SLAB.get()));

        dropSelf(ModBlocks.MYTHRIL_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.MYTHRIL_BUTTON.get());

        dropSelf(ModBlocks.MYTHRIL_FENCE.get());
        dropSelf(ModBlocks.MYTHRIL_FENCE_GATE.get());
        dropSelf(ModBlocks.MYTHRIL_WALL.get());
        dropSelf(ModBlocks.MYTHRIL_TRAPDOOR.get());

        add(ModBlocks.MYTHRIL_DOOR.get(),
                block -> createDoorTable(ModBlocks.MYTHRIL_DOOR.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
