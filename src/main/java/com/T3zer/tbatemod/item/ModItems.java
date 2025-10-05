package com.T3zer.tbatemod.item;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.item.custom.ChiselItem;
import com.T3zer.tbatemod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

//it's where we need to add each item to make them referenced in the game
public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TbateMod.MOD_ID);

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> MYTHRIL = ITEMS.register("mythril",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_MYTHRIL = ITEMS.register("raw_mythril",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MYSTERIOUS_EGG = ITEMS.register("mysterious_egg",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.RADISH)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.tbatemod.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final  DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> MYTHRIL_SWORD = ITEMS.register("mythril_sword",
            () -> new SwordItem(ModToolTires.MYTHRIL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTires.MYTHRIL,5, 3f))));
    public static final DeferredItem<PickaxeItem> MYTHRIL_PICKAXE = ITEMS.register("mythril_pickaxe",
            () -> new PickaxeItem(ModToolTires.MYTHRIL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTires.MYTHRIL,1.0f, -2.8f))));
public static final DeferredItem<AxeItem> MYTHRIL_AXE = ITEMS.register("mythril_axe",
            () -> new AxeItem(ModToolTires.MYTHRIL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTires.MYTHRIL,6, -3.2f))));
    public static final DeferredItem<HoeItem> MYTHRIL_HOE = ITEMS.register("mythril_hoe",
            () -> new HoeItem(ModToolTires.MYTHRIL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTires.MYTHRIL,-3, 0.0f))));
    public static final DeferredItem<ShovelItem> MYTHRIL_SHOVEL = ITEMS.register("mythril_shovel",
            () -> new ShovelItem(ModToolTires.MYTHRIL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTires.MYTHRIL,1.5f, 0.0f))));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
