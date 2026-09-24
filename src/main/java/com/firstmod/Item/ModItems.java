package com.firstmod.Item;

import com.firstmod.Item.custom.StandArrowFunction;
import com.firstmod.jojo.JojoMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ModItems {

    /*Item's basic registration - copying first line not necessary copy second line - first step*
    /*you can copy the second line and change "registerItem" to registerSimpleItem to get rid of all that is after the name*/

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(JojoMod.MODID);

    public static final DeferredItem<Item> STAND_ARROW = ITEMS.registerItem("stand_arrow", properties -> new StandArrowFunction(properties
            .rarity(Rarity.EPIC)) {
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.jojomod.stand_arrow.tooltip"));
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });


    public static final DeferredItem<Item> RAW_OUTERITE = ITEMS.registerSimpleItem("raw_outerite");

    public static final DeferredItem<Item> SMELTED_OUTERITE = ITEMS.registerSimpleItem("smelted_outerite");

    public static final DeferredItem<Item> COMPRESSED_OUTERTIE = ITEMS.registerSimpleItem("compressed_outerite");

public static final DeferredItem<Item> STAND_ARROW_TIP = ITEMS.registerSimpleItem("stand_arrow_tip");






    public static void register(IEventBus eventBus)
    {

        ITEMS.register(eventBus);
    }
}
