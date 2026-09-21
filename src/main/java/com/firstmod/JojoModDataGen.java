package com.firstmod;

import com.firstmod.block.ModBlocks;
import com.firstmod.datagen.*;
import com.firstmod.jojo.JojoMod;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.core.HolderLookup;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = JojoMod.MODID)
public class JojoModDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event)
    {
        DataGenerator generator = event.getGenerator();

        PackOutput packOutput = generator.getPackOutput();

        var lookupProvider  =  event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));

        generator.addProvider(true, new ModBlockTagsProvider(packOutput, lookupProvider));

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),

                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));

        generator.addProvider(true, new ModSoundProvider(packOutput));
    }
}
