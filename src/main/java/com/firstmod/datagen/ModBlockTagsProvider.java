package com.firstmod.datagen;

import com.firstmod.block.ModBlocks;
import com.firstmod.jojo.JojoMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, JojoMod.MODID);
    }

    @Override
    /*unstable mine potential*/
    /*make the blocks minable*/

    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.METEOR_INSIDE_BLOCK.getKey());

    /*make them be mined with a specific tool which is determent by the attribute about*/

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.METEOR_INSIDE_BLOCK.getKey());
    }
}
