package com.firstmod.event;

import com.firstmod.stand.standEntity.spesificstands.ModEntities;
import com.firstmod.stand.standEntity.spesificstands.d4c.DFourCEntity;
import com.firstmod.stand.standEntity.spesificstands.d4c.client.DFourCModel;
import net.minecraft.util.datafix.fixes.EntityAttributeBaseValueFix;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

public class ModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.DFOURC.get(), DFourCEntity.createAttributes().build());
    }
}
