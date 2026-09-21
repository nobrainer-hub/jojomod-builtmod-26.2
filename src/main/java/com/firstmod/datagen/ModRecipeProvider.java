package com.firstmod.datagen;

import com.firstmod.Item.ModItems;
import com.firstmod.jojo.JojoMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {


    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner{

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries,output);
        }

        @Override
        public String getName() {
            return "JojoMod Recipes";
        }
    }

    @Override
    protected void buildRecipes() {

            /*Recipe template*/

     shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STAND_ARROW_TIP.get())
             /*.pattern("BAB")
             .pattern("ABA")
             .pattern("CBC")*/
             .pattern(" A ")
             .pattern("ACA")
             .pattern("B B")
             .define('A', ModItems.SMELTED_OUTERITE.get())
             .define('B', Items.GOLD_INGOT)
             .define('C', Items.IRON_INGOT)
             .unlockedBy(getHasName(ModItems.SMELTED_OUTERITE.get()), has(ModItems.SMELTED_OUTERITE))
             .group("smelted_outerite")
             .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STAND_ARROW.get())

                .pattern("  A")
                .pattern(" B ")
                .pattern("C  ")
                .define('A', ModItems.STAND_ARROW_TIP.get())
                .define('B', Items.STICK)
                .define('C', Items.FEATHER)
                .unlockedBy(getHasName(ModItems.STAND_ARROW.get()), has(ModItems.STAND_ARROW))
                .group("stand_arrow")
                .save(output);

    /*make an item smeltable by copying the first and second line and adding all the items which provide the same material  after smelted to the  first list*/

     List<ItemLike> OUTERITE_SMELTABLES = List.of(ModItems.RAW_OUTERITE);

     oreSmelting(OUTERITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SMELTED_OUTERITE.get()
     , 0.7f, 6000 , "smelted_outerite");
     oreBlasting(OUTERITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.SMELTED_OUTERITE.get()
             , 1.0f, 2400 , "smelted_outerite");

    }
        /*Smelting template*/

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for (ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime,
                            factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, JojoMod.MODID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
