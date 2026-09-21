package com.firstmod.sound;

import com.firstmod.jojo.JojoMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, JojoMod.MODID);

    /*sound creating - step 1 - copy first lines*/

    public static final Supplier<SoundEvent>  UPON_CONSUMING_ARROW = SOUND_EVENTS.register("upon_consuming_arrow"
    , () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(JojoMod.MODID, "upon_consuming_arrow")));

    public static final Supplier<SoundEvent>  AFTER_CONSUMING_ARROW = SOUND_EVENTS.register("after_consuming_arrow"
            , () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(JojoMod.MODID, "after_consuming_arrow")));


    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }
}
