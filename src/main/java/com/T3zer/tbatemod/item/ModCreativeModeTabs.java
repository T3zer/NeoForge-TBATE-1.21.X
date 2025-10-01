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
    //list the creative tab in a deferred register and link the tab to the mod id
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TbateMod.MOD_ID);
    //Creative tab for Items of TBATE mod
    public static final Supplier<CreativeModeTab> TBATE_ITEMS_TAB = CREATIVE_MODE_TAB.register("tbate_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MYSTERIOUS_EGG.get()))
                    .title(Component.translatable("creativetab.tbatemod.tbate_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept((ModItems.MYTHRIL));
                        output.accept((ModItems.MYSTERIOUS_EGG));
                        output.accept((ModItems.RAW_MYTHRIL));
                        output.accept((ModItems.CHISEL));
                    }).build());
    //Creative tab for Blocks of TBATE mod
    public static final Supplier<CreativeModeTab> TBATE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("tbate_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TbateMod.MOD_ID, "tbate_items_tab"))
                    .title(Component.translatable("creativetab.tbatemod.tbate_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept((ModBlocks.MITHRIL_BLOCK));
                        output.accept((ModBlocks.MYTHRIL_ORE));
                        output.accept((ModBlocks.MYTHRIL_DEEPSLATE_ORE));
                        output.accept((ModBlocks.MAGIC_BLOCK));
                    }).build());

    //method who is called in the main class to add the creative tab in the game
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}