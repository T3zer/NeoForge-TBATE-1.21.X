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
                        output.accept((ModItems.RAW_MYTHRIL));

                        output.accept((ModItems.CHISEL));
                        output.accept((ModItems.RADISH));
                        output.accept((ModItems.MYSTERIOUS_EGG));

                        output.accept((ModItems.STARLIGHT_ASHES));
                        output.accept((ModItems.FROSTFIRE_ICE));

                        output.accept((ModItems.MYTHRIL_SWORD));
                        output.accept((ModItems.MYTHRIL_PICKAXE));
                        output.accept((ModItems.MYTHRIL_AXE));
                        output.accept((ModItems.MYTHRIL_SHOVEL));
                        output.accept((ModItems.MYTHRIL_HOE));

                        output.accept((ModItems.MYTHRIL_HAMMER));

                        output.accept(ModItems.MYTHRIL_HELMET);
                        output.accept(ModItems.MYTHRIL_CHESTPLATE);
                        output.accept(ModItems.MYTHRIL_LEGGINGS);
                        output.accept(ModItems.MYTHRIL_BOOTS);


                    }).build());
    //Creative tab for Blocks of TBATE mod
    public static final Supplier<CreativeModeTab> TBATE_BLOCKS_TAB = CREATIVE_MODE_TAB.register("tbate_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MYTHRIL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TbateMod.MOD_ID, "tbate_items_tab"))
                    .title(Component.translatable("creativetab.tbatemod.tbate_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept((ModBlocks.MYTHRIL_BLOCK));
                        output.accept((ModBlocks.MYTHRIL_ORE));
                        output.accept((ModBlocks.MYTHRIL_DEEPSLATE_ORE));

                        output.accept((ModBlocks.MAGIC_BLOCK));


                        output.accept(ModBlocks.MYTHRIL_PRESSURE_PLATE);
                        output.accept(ModBlocks.MYTHRIL_BUTTON);

                        output.accept(ModBlocks.MYTHRIL_FENCE);
                        output.accept(ModBlocks.MYTHRIL_FENCE_GATE);
                        output.accept(ModBlocks.MYTHRIL_WALL);

                        output.accept(ModBlocks.MYTHRIL_DOOR);
                        output.accept(ModBlocks.MYTHRIL_TRAPDOOR);


                    }).build());

    //method who is called in the main class to add the creative tab in the game
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}