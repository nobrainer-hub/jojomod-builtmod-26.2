package com.firstmod.datagen;

import com.firstmod.jojo.JojoMod;
import com.firstmod.sound.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundProvider extends SoundDefinitionsProvider {

    public ModSoundProvider(PackOutput output) {
        super(output, JojoMod.MODID);
    }

    @Override
    public void registerSounds() {

        /*connect the actual sound to variable*/

        add(ModSounds.UPON_CONSUMING_ARROW.get(), definition().subtitle("sounds.jojomod.upon_consuming_arrow")
                .with(sound(Identifier.fromNamespaceAndPath(JojoMod.MODID, "upon_consuming_arrow"))));

        add(ModSounds.AFTER_CONSUMING_ARROW.get(), definition().subtitle("sounds.jojomod.after_consuming_arrow")
                .with(sound(Identifier.fromNamespaceAndPath(JojoMod.MODID, "after_consuming_arrow"))));
    }
}
