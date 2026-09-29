package com.firstmod.menu;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;


public class ModStatsMenu extends Screen {

    private static final Identifier BACKGROUND = Identifier.tryParse("jojomod:textures/menu/window.png");

    public ModStatsMenu(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        //where to add all the interactive stuff

        super.init();
    }

    @Override //all of the background non interactable stuff
    public void extractRenderState(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        //when to stop drawing the texture
        int iWidth = 252;
        int iHeight = 140;
        //where to start drawing the texture(0,0 is the top left corner)
        int x = (this.width - iWidth) / 2;
        int y = (this.height - iHeight) / 2;
        assert BACKGROUND != null;
        extractMenuBackground(graphics);
        graphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, x, y, 0, 0, iWidth, iHeight, 256, 256);
        //draws the advancements window
        graphics.fill(x + 8, y + 17, x + 245, y + 133, 0xFE222222); //fills inside the window
        graphics.pose().pushMatrix(); //saves the current scale
        float scale = 0.9F; //zoom multiplier
        graphics.pose().scale(scale, scale);
        graphics.text(this.font, Component.literal("stand:???"), Math.round((x + 17) / scale), Math.round((y + 10) / scale), 0xFFFF0000);
        graphics.pose().popMatrix(); //returns to the previous value
        super.extractRenderState(graphics, mouseX, mouseY, a);
    }

    @Override
    public boolean isPauseScreen() { //pauses the game in single player
        return super.isPauseScreen();
    }
}
