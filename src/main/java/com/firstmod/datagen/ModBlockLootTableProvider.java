package com.firstmod.datagen;

import com.firstmod.Item.ModItems;
import com.firstmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {


    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        /*loot table*/

        /*a way for a block to drop itself*/



        /*a way for a block to drop one custom item*/

        add(ModBlocks.METEOR_INSIDE_BLOCK.get(), createOreDrop(ModBlocks.METEOR_INSIDE_BLOCK.get(), ModItems.RAW_OUTERITE.get()));

        /*a way to make a block drop a couple of the items instead of one - METHOD*/

        add(ModBlocks.METEOR_INSIDE_BLOCK.get(),
                createMultipleOreDrops(ModBlocks.METEOR_INSIDE_BLOCK.get(), ModItems.RAW_OUTERITE.get(), 1, 2));

        }
    /*a way to make a block drop a couple of the items instead of one - METHOD - to make an addition create a new one, name it and tag properly*/

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))));
                               /*allow to make fortune effect the amount of drops*/

                                //.apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}







