package com.T3zer.tbatemod.item;

import com.T3zer.tbatemod.TbateMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TbateMod.MOD_ID);

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
