package com.T3zer.tbatemod.item;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.awt.*;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TbateMod.MOD_ID);

    public static final Supplier<CreativeModeTab> TBATE_ITEMS_TAB = CREATIVE_MODE_TAB.register("tbate_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MYSTERIOUS_EGG.get()))
                    .title(Component.translatable("creativetab.tbatemod.tbate_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept((ModItems.MYTHRIL));
                        output.accept((ModItems.MYSTERIOUS_EGG));
                        output.accept((ModItems.RAW_MYTHRIL));
                    }).build());

    public static final Supplier<CreativeModeTab> TBATE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("tbate_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TbateMod.MOD_ID, "tbate_items_tab"))
                    .title(Component.translatable("creativetab.tbatemod.tbate_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept((ModBlocks.MITHRIL_BLOCK));
                        output.accept((ModBlocks.MYTHRIL_ORE));
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}