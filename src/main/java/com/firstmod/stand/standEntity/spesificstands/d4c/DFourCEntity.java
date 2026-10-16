package com.firstmod.stand.standEntity.spesificstands.d4c;

import com.firstmod.stand.standEntity.StandType;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class DFourCEntity extends StandType {



    public DFourCEntity(EntityType<? extends DFourCEntity> type, Level level) {
        super(type, level);
    }


    public final AnimationState idleAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;

    //animations
    private void setupAnimationStates()
    {
        if (this.idleAnimationTimeout <= 0)
        {
            //the value determent the time length of the whole animation
            this.idleAnimationTimeout =80;
            this.idleAnimationState.start(this.tickCount);}
        else {
            --this.idleAnimationTimeout;}}

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide())
        {
            this.setupAnimationStates();
        }
    }


    public static AttributeSupplier.Builder createAttributes()
    {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.FOLLOW_RANGE, 64d)
                .add(Attributes.GRAVITY , 0d)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1d)
                .add(Attributes.MAX_HEALTH, 20d )
                .add(Attributes.MOVEMENT_SPEED, 0.3d);
    }

}

