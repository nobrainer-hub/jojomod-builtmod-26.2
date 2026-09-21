package com.firstmod.block;

import com.firstmod.Item.ModItems;
import com.firstmod.jojo.JojoMod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {

    /*basic block registration*/

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(JojoMod.MODID);

    /*define the block and its properties - copy first three lines and change according to preference - first step*/

    public static final DeferredBlock<Block> METEOR_SHELL_BLOCK = registerBlock("meteor_shell_block",
            properties -> new Block(properties.noLootTable().destroyTime(-0.1f).explosionResistance(12.0f)
                    .sound(SoundType.ANCIENT_DEBRIS)));

    public static final DeferredBlock<Block> METEOR_INSIDE_BLOCK = registerBlock("meteor_inside_block",
            properties -> new DropExperienceBlock(UniformInt.of(5,6),properties.destroyTime(50.0f).explosionResistance(1200f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name,
                                                                    Function<BlockBehaviour.Properties, T> function)
    {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)

    {
        ModItems.ITEMS.registerItem(name,properties -> new BlockItem(block.get(),
                properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
