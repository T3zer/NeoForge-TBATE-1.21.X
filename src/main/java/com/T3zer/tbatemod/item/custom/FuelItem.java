package com.T3zer.tbatemod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nullable;

public class FuelItem extends Item {

    // variable which stock the burn time
    private int burntime = 0;

    public FuelItem(Properties properties,int burntime){
        super(properties);
        this.burntime = burntime;

    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return burntime;
    }
}
