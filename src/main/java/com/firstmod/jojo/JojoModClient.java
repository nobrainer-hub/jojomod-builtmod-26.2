package com.firstmod.jojo;

import com.firstmod.keymapping.ModKeyMappings;
import com.firstmod.menu.ModStatsMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = JojoMod.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = JojoMod.MODID, value = Dist.CLIENT)
public class JojoModClient {
    public JojoModClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        ModKeyMappings.register();
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        JojoMod.LOGGER.info("HELLO FROM CLIENT SETUP");
        JojoMod.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
    //lets you change the keybind ingame(aka. register it)/ not required
    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(ModKeyMappings.PRESS_UI.get());
    }
    // checks if a keybind was pressed
    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        while (ModKeyMappings.PRESS_UI.get().consumeClick()){
            //Minecraft.getInstance().player.sendSystemMessage(Component.literal("SUMMONNING STANDO!!!"));
            Minecraft.getInstance().setScreenAndShow(new ModStatsMenu(Component.translatable("menu.jojomod.customvisualmenu")));
        }
    }
}
