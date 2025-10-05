package com.T3zer.tbatemod.datagen;

import com.T3zer.tbatemod.TbateMod;
import com.T3zer.tbatemod.block.ModBlocks;
import com.T3zer.tbatemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> MYTHRIL_SMELTABLES = List.of(ModItems.RAW_MYTHRIL,
                ModBlocks.MYTHRIL_ORE, ModBlocks.MYTHRIL_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MYTHRIL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.MYTHRIL.get())
                .unlockedBy("has_mythril", has(ModItems.MYTHRIL)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYTHRIL.get(), 9)
                .requires(ModBlocks.MYTHRIL_BLOCK)
                .unlockedBy("has_mythril_block", has(ModBlocks.MYTHRIL_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYTHRIL.get(), 18)
                .requires(ModBlocks.MAGIC_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK))
                .save(recipeOutput, "tbatemodbytr:bismuth_from_magic_block");

        oreSmelting(recipeOutput, MYTHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MYTHRIL.get(), 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, MYTHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MYTHRIL.get(), 0.25f, 100, "bismuth");

        stairBuilder(ModBlocks.MYTHRIL_STAIRS.get(), Ingredient.of(ModItems.MYTHRIL)).group("mythril")
                .unlockedBy("has_mythril", has(ModItems.MYTHRIL)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYTHRIL_SLAB.get(), ModItems.MYTHRIL.get());

        buttonBuilder(ModBlocks.MYTHRIL_BUTTON.get(), Ingredient.of(ModItems.MYTHRIL.get())).group("mythril")
                .unlockedBy("has_mythril", has(ModItems.MYTHRIL.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.MYTHRIL_PRESSURE_PLATE.get(), ModItems.MYTHRIL.get());

        fenceBuilder(ModBlocks.MYTHRIL_FENCE.get(), Ingredient.of(ModItems.MYTHRIL.get())).group("mythril")
                .unlockedBy("has_mythril", has(ModItems.MYTHRIL.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.MYTHRIL_FENCE_GATE.get(), Ingredient.of(ModItems.MYTHRIL.get())).group("mythril")
                .unlockedBy("has_mythril", has(ModItems.MYTHRIL.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYTHRIL_WALL.get(), ModItems.MYTHRIL.get());

        doorBuilder(ModBlocks.MYTHRIL_DOOR.get(), Ingredient.of(ModItems.MYTHRIL.get())).group("mythril")
                .unlockedBy("has_mythril", has(ModItems.MYTHRIL.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.MYTHRIL_TRAPDOOR.get(), Ingredient.of(ModItems.MYTHRIL.get())).group("mythril")
                .unlockedBy("has_mythril", has(ModItems.MYTHRIL.get())).save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TbateMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}