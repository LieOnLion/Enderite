package io.github.lieonlion.enderite.init;

import io.github.lieonlion.enderite.Enderite;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlocksInit {
	private BlocksInit() {}
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Enderite.MODID);

	public static final RegistryObject<Block> ENDERITE_BLOCK = BLOCKS.register("enderite_block",
			() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).strength(60, 1300).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
	public static final RegistryObject<Block> PRIMORDIAL_REMNANTS = BLOCKS.register("primordial_remnants",
			() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).strength(40, 1100).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> OBSIDIAN_INFUSED_ENDERITE_BLOCK = BLOCKS.register("obsidian_infused_enderite_block",
			() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).strength(75, 1400).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
}