package com.firstmod.keymapping;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {
    private static final KeyMapping KEY_MAPPING_UI = new KeyMapping("key.jojomod.ui",
            //the place where you change the keybind
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, KeyMapping.Category.MISC);

    public static final Lazy<KeyMapping> PRESS_UI = Lazy.of(() -> KEY_MAPPING_UI);

    public static void register(){

    }
}
