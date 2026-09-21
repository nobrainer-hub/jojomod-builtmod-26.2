package com.firstmod.datagen;

import com.firstmod.Item.ModItems;
import com.firstmod.block.ModBlocks;
import com.firstmod.jojo.JojoMod;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output , JojoMod.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        /*Items's model defining - copy and change first line - third step*/


        itemModels.generateFlatItem(ModItems.STAND_ARROW.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.RAW_OUTERITE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.SMELTED_OUTERITE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.COMPRESSED_OUTERTIE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.STAND_ARROW_TIP.get(), ModelTemplates.FLAT_ITEM);

        /*Blocks's model defining - copy and change first line - third step*/


        blockModels.createTrivialCube(ModBlocks.METEOR_SHELL_BLOCK.get());

        blockModels.createTrivialCube(ModBlocks.METEOR_INSIDE_BLOCK.get());


    }
}
