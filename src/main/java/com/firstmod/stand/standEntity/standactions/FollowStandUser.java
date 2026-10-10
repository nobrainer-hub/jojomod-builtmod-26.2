package com.firstmod.stand.standEntity.standactions;

import com.firstmod.stand.standEntity.StandType;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class FollowStandUser extends Goal {

    private final StandType stand;
    private final double speedModifier;
    private final float startDistance;
    private final float stopDistance;

    public FollowStandUser(StandType stand, double speedModifier, float startDistance, float stopDistance) {
        this.stand = stand;
        this.speedModifier = speedModifier;
        this.startDistance = startDistance;
        this.stopDistance = stopDistance;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        var owner = this.stand.getUser();
        if (owner == null || owner.isSpectator()) {
            return false;
        }
        return this.stand.distanceToSqr(owner) >= (double)(this.startDistance * this.startDistance);
    }

    @Override
    public void tick() {
        var owner = this.stand.getUser();
        if (owner != null) {
            this.stand.getLookControl().setLookAt(owner, 10.0F, (float)this.stand.getMaxHeadXRot());
            if (this.stand.distanceToSqr(owner) >= (double)(this.stopDistance * this.stopDistance)) {
                this.stand.getNavigation().moveTo(owner, this.speedModifier);
            }
        }
    }
}
