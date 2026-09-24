package com.firstmod.stand;

import com.firstmod.block.ModBlocks;
import com.firstmod.jojo.JojoMod;
import com.mojang.serialization.Codec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import java.util.function.Supplier;

public class TechnicalStats {

     public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
             DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, JojoMod.MODID);

          public static final Supplier<AttachmentType<Boolean>> HAS_STAND = ATTACHMENT_TYPES.register(
             "has_stand", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL.fieldOf("has_stand"))
                          .copyOnDeath()
                          .build());


}
