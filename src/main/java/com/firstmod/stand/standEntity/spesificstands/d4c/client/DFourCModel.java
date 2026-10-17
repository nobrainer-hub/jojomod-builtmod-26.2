package com.firstmod.stand.standEntity.spesificstands.d4c.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class DFourCModel extends EntityModel<DFourCRendererState> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart left_leg;
    private final ModelPart right_leg;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart ears;
    private final ModelPart head;
    private final ModelPart body;

    // private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idlingAnimation;


    public DFourCModel(ModelPart root) {
        super(root);
        this.left_leg = root.getChild("left_leg");
        this.right_leg = root.getChild("right_leg");
        this.right_arm = root.getChild("right_arm");
        this.left_arm = root.getChild("left_arm");
        this.ears = root.getChild("ears");
        this.head = root.getChild("head");
        this.body = root.getChild("body");

        //this.walkingAnimation = DFourCAnimations.WALK.bake(root);
        this.idlingAnimation = DFourCAnimations.idle.bake(root);
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.6412F, 2.0F, 2.9659F));

        PartDefinition top_left_leg_r1 = left_leg.addOrReplaceChild("top_left_leg_r1", CubeListBuilder.create().texOffs(40, 24).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition bottom_left_leg_r1 = left_leg.addOrReplaceChild("bottom_left_leg_r1", CubeListBuilder.create().texOffs(0, 37).addBox(-2.123F, -0.1836F, -3.0261F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7567F, 3.1348F, 0.8783F, 0.3488F, 0.0132F, -0.041F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(34, 38).addBox(-2.8024F, -2.0082F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.1588F, 2.0F, 2.9659F));

        PartDefinition bottom_right_leg_r1 = right_leg.addOrReplaceChild("bottom_right_leg_r1", CubeListBuilder.create().texOffs(30, 13).addBox(-2.0F, 4.0175F, -4.7362F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0412F, -1.3107F, 1.073F, 0.3491F, -0.0017F, -0.0436F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -12.0F, 3.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition top_right_arm_r1 = right_arm.addOrReplaceChild("top_right_arm_r1", CubeListBuilder.create().texOffs(0, 48).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(46, 9).addBox(-8.0F, -20.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 22.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition bottom_right_arm_r1 = right_arm.addOrReplaceChild("bottom_right_arm_r1", CubeListBuilder.create().texOffs(24, 25).addBox(-1.8F, -4.5F, -2.0F, 3.6F, 9.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.8222F, 10.5603F, -0.8916F, -0.2182F, 0.0F, 0.0436F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0316F, -13.13F, 3.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition bottom_left_arm_r1 = left_arm.addOrReplaceChild("bottom_left_arm_r1", CubeListBuilder.create().texOffs(30, -1).addBox(-1.8F, -4.5F, -2.0F, 3.6F, 9.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.2089F, 12.6467F, -0.9273F, -0.2182F, 0.0F, 0.0436F));

        PartDefinition top_left_arm_r1 = left_arm.addOrReplaceChild("top_left_arm_r1", CubeListBuilder.create().texOffs(16, 47).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-8.0F, -20.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0312F, 24.0864F, -0.0356F, 0.0F, 0.0F, 0.0873F));

        PartDefinition ears = partdefinition.addOrReplaceChild("ears", CubeListBuilder.create(), PartPose.offset(6.0F, -11.0F, 3.0F));

        PartDefinition top_right_ear_r1 = ears.addOrReplaceChild("top_right_ear_r1", CubeListBuilder.create().texOffs(42, 48).addBox(-1.5471F, -9.2584F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(50, 38).addBox(-1.4529F, -11.2416F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1592F, -10.769F, -1.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition top_left_ear_r1 = ears.addOrReplaceChild("top_left_ear_r1", CubeListBuilder.create().texOffs(46, 18).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -21.0F, -1.0F, 0.0F, 0.0F, 0.0436F));

        PartDefinition bottom_left_ear_r1 = ears.addOrReplaceChild("bottom_left_ear_r1", CubeListBuilder.create().texOffs(32, 48).addBox(-2.0F, -10.0F, -1.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -10.0F, -1.0F, 0.0F, 0.0F, 0.0436F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 34).addBox(-0.5F, 3.5F, -2.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.5F, -4.0F, -4.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(16, 38).addBox(-2.5F, -4.0F, -4.57F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -18.5F, 3.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 25).addBox(-4.0F, 6.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 48).addBox(-5.0F, 0.0F, -3.85F, 10.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 22).addBox(-5.0F, 5.5625F, -3.84F, 10.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    public void setupAnim(DFourCRendererState state) {
        //this.root().getAllParts().forEach(ModelPart::resetPose);
        this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
    }
}
