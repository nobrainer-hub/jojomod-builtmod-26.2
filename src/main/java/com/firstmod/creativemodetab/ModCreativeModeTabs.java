package com.firstmod.creativemodetab;

import com.firstmod.Item.ModItems;
import com.firstmod.block.ModBlocks;
import com.firstmod.jojo.JojoMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JojoMod.MODID);
    public static final Supplier<CreativeModeTab> JOJOS_ITEMS_TAB = CREATIVE_MODE_TABS.register("jojo_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STAND_ARROW.get()))
                    .title(Component.translatable("creativetab.jojomod.jojo_items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .withTabsAfter(Identifier.fromNamespaceAndPath(JojoMod.MODID, "jojo_stands_tab"))
                    .displayItems((itemDisplayParameters, output) -> {  //adds the items to the tab
                        output.accept(ModItems.STAND_ARROW);
                        output.accept(ModItems.RAW_OUTERITE);
                        output.accept(ModItems.SMELTED_OUTERITE);
                        output.accept(ModItems.COMPRESSED_OUTERTIE);
                        output.accept(ModItems.STAND_ARROW_TIP);
                        output.accept(ModBlocks.METEOR_SHELL_BLOCK);
                        output.accept(ModBlocks.METEOR_INSIDE_BLOCK);
                    })

                    .build());

    public  static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
