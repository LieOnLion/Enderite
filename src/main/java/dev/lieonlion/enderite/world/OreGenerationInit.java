package dev.lieonlion.enderite.world;

import dev.lieonlion.enderite.Enderite;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class OreGenerationInit {
    public static final RegistryKey<PlacedFeature> PRIMORDIAL_REMNANTS_PLACED_KEY =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Enderite.MODID, "primordial_remnants_placed"));

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_END),
                GenerationStep.Feature.UNDERGROUND_ORES, PRIMORDIAL_REMNANTS_PLACED_KEY);
    }
}