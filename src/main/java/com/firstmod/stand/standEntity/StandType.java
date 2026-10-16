package com.firstmod.stand.standEntity;

import com.firstmod.stand.standEntity.standbaseactions.FollowStandUser;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Optional;
import java.util.UUID;

public abstract class StandType extends PathfinderMob {

    protected final int PRIORITY_FOLLOW_USER = 1;
    protected final int PRIORITY_ATTACK_BARRAGE = 0;
    protected final int PRIORITY_ATTACK_PUNCH = 0;


    public StandType(EntityType<? extends PathfinderMob> type, Level level) {super(type, level);}



    private Optional<UUID> ownerUUID = Optional.empty();

    public void setUser(Player player) {
        this.ownerUUID = Optional.of(player.getUUID());
    }

    public LivingEntity getUser() {
        return this.ownerUUID
                .map(uuid -> this.level().getPlayerByUUID(uuid))
                .orElse(null);
    }

    @Override
    public void registerGoals() {
        goalSelector.addGoal(PRIORITY_FOLLOW_USER, new FollowStandUser(this, 2d, 1f, 1f ));

        SpecialAbilities();
    }

    public static void SpecialAbilities()
    {

    }
}
