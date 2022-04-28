package com.titan.titancraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TitancraftSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TitanCraft.MODID);

    public static final RegistryObject<SoundEvent> MADBOT_AMBIENT = SOUNDS.register("entity.madbot.ambient",
            () -> new SoundEvent(new ResourceLocation(TitanCraft.MODID, "entity.madbot.ambient")));

    public static final RegistryObject<SoundEvent> MADBOT_HURT = SOUNDS.register("entity.madbot.hurt",
            () -> new SoundEvent(new ResourceLocation(TitanCraft.MODID, "entity.madbot.hurt")));

    public static final RegistryObject<SoundEvent> MADBOT_DEATH = SOUNDS.register("entity.madbot.death",
            () -> new SoundEvent(new ResourceLocation(TitanCraft.MODID, "entity.madbot.death")));
}
