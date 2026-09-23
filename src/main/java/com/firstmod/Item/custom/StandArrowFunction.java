package com.firstmod.Item.custom;

import com.firstmod.sound.ModSounds;
import com.firstmod.stand.TechnicalStats;
import net.minecraft.advancements.predicates.FoodPredicate;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.enchantment.effects.SpawnParticlesEffect;
import net.minecraft.world.level.Level;

import java.util.Scanner;


public class StandArrowFunction extends Item{

    public StandArrowFunction(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        RandomSource random = level.getRandom();
        int ChanceOfNotDying = random.nextInt(100);

        if (ChanceOfNotDying + 1 >= 50)
            player.addEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 9));

        /*Player has the stand only status - connected to TechnicalStats*/

        player.setData(TechnicalStats.HAS_STAND, true);


        return super.use(level, player, hand);
    }

        /*Eatable properties*/

    public static final FoodProperties StandArrowEatStatus = new FoodProperties.Builder().nutrition(4).saturationModifier(1.2f).alwaysEdible().build();

    public static final Consumable STAND_ARROW_CONSUMABLE = Consumables.defaultFood().consumeSeconds(0.1f).
            onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 1200)))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 400), 1f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200))).hasConsumeParticles(false)


            //.animation()
            .soundAfterConsume(Holder.direct(ModSounds.AFTER_CONSUMING_ARROW.get()))
            .build();

}
