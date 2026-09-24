package com.firstmod.Item.custom;

import com.firstmod.sound.ModSounds;
import net.minecraft.advancements.predicates.FoodPredicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.enchantment.effects.SpawnParticlesEffect;
import net.minecraft.world.level.Level;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import java.util.function.Consumer;
import java.util.Scanner;


public class StandArrowFunction extends Item{

    public StandArrowFunction(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);    // plays the animation and allows the start of finishUsingItem
        return InteractionResult.SUCCESS;
    }

    @Override
    public ItemStack finishUsingItem(@NotNull ItemStack itemStack, Level level, @NotNull LivingEntity entity) {
        if(level.isClientSide()){ //stops the music as to not spam it
            Minecraft.getInstance().getSoundManager().stop(
                    ModSounds.AFTER_CONSUMING_ARROW.get().location(), SoundSource.PLAYERS
            );
        }
        if(!level.isClientSide()){ //adds the effects and plays the music when using the item
            level.playSound(null, entity, ModSounds.AFTER_CONSUMING_ARROW.get(), SoundSource.PLAYERS, 1f, 1f);
            entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 400, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1200, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0));
            if (level instanceof ServerLevel serverLevel && entity instanceof ServerPlayer serverPlayer) { //removes durability every use
                itemStack.hurtAndBreak(1, serverLevel, serverPlayer, (Item item) -> {entity.onEquippedItemBroken(itemStack.getItem(), EquipmentSlot.MAINHAND);});
            }
        }
        return itemStack;
    }
}
