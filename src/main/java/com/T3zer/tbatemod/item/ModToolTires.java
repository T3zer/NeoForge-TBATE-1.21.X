package com.T3zer.tbatemod.item;

import com.T3zer.tbatemod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTires {
    public static final Tier MYTHRIL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_MYTHRIL_TOOL,
            1400, 4f, 3f, 28, () -> Ingredient.of(ModItems.MYTHRIL));


}
