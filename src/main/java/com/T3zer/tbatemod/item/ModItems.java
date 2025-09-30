package com.T3zer.tbatemod.item;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
