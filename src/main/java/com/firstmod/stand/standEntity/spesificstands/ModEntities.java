package com.firstmod.stand.standEntity.spesificstands;

import com.firstmod.jojo.JojoMod;
import com.firstmod.stand.standEntity.spesificstands.d4c.DFourCEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>>ENTITY_TYPES  =
            DeferredRegister.createEntities(JojoMod.MODID);

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }

    public static final ResourceKey<EntityType<?>> DFOURC_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(JojoMod.MODID, "dfourc"));

    public static final Supplier<EntityType<DFourCEntity>> DFOURC = ENTITY_TYPES.register("dfourc",
            ()->EntityType.Builder.of(DFourCEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.95f).build(DFOURC_KEY));
}
