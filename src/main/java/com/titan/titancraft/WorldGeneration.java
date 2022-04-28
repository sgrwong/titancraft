package com.titan.titancraft;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class WorldGeneration {
    public static final List<ConfiguredFeature<?, ?>> OVERWORLD_ORES = new ArrayList<>();

    @EventBusSubscriber(modid = TitanCraft.MODID, bus = EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber {
        @SubscribeEvent
        //adds all ores to biome on loading
        public static void biomeLoading(BiomeLoadingEvent event) {
            List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
            WorldGeneration.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));

            MobSpawnInfoBuilder spawns = event.getSpawns();
            spawns.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(TitancraftModEntities.MAD_BOT, 10, 1, 4));
        }
    }

    //registers the configured feature
    private static <Config extends FeatureConfiguration> ConfiguredFeature<Config, ?> register(String name, ConfiguredFeature<Config, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(TitanCraft.MODID, name), feature);
    }

    //zLower -> The minimum z co-ordinate the ore can spawn at
    //zHigher -> The maximum z co-ordinate the ore can spawn at
    //oresPerChunk -> How many of the ore can spawn per chunk. Iron is 40. For more info see net.minecraft.data.worldgen.Features
    private static void configureAndRegister(String registryName, RegistryObject<Block> oreBlock, int oresPerVain, int zLower, int zHigher, int oresPerChunk) {
        ConfiguredFeature<?, ?> ore = Feature.ORE.configured(new OreConfiguration(List.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES,
                oreBlock.get().defaultBlockState())),
                oresPerVain)).rangeUniform(VerticalAnchor.aboveBottom(zLower), VerticalAnchor.aboveBottom(zHigher)).squared().count(oresPerChunk);
        OVERWORLD_ORES.add(register(registryName, ore));
    }

    public static void registerOres() {
        configureAndRegister("titanium_ore", TitancraftModBlocks.TITANIUM_ORE, 9, 0, 50, 25);
        configureAndRegister("aluminium_ore", TitancraftModBlocks.ALUMINIUM_ORE, 6, 30, 60, 40);
    }
}
