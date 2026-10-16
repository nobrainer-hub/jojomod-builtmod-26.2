package com.firstmod.stand.standEntity.spesificstands.d4c.client;

import com.firstmod.jojo.JojoMod;
import com.firstmod.stand.standEntity.spesificstands.d4c.DFourCEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class DFourCRenderer extends MobRenderer<DFourCEntity, DFourCRendererState, DFourCModel> {
    public DFourCRenderer(EntityRendererProvider.Context context) {
        super(context, new DFourCModel(context.bakeLayer(ModModelLayerLocations.DFOURC)), 0.0f);
    }

    @Override
    public Identifier getTextureLocation(DFourCRendererState state) {
        return Identifier.fromNamespaceAndPath(JojoMod.MODID, "textures/entity/dfourc/dfourc.png");
    }

    @Override
    public DFourCRendererState createRenderState() {
        return new DFourCRendererState();
    }

    @Override
    public void extractRenderState(DFourCEntity entity, DFourCRendererState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
