package dev.lieonlion.enderite.init;

import dev.lieonlion.enderite.Enderite;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlocksInit {
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).strength(60, 1300).requiresTool().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block PRIMORDIAL_REMNANTS = registerBlock("primordial_remnants",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).strength(40, 1100).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block OBSIDIAN_INFUSED_ENDERITE_BLOCK = registerBlock("obsidian_infused_enderite_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).strength(75, 1400).requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Enderite.asId(name), block);
    }

    public static void registerBlocks() {}
}