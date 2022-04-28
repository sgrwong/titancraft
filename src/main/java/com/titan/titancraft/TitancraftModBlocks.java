package com.titan.titancraft;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class TitancraftModBlocks {
	// Creates a deferred register to register our blocks into the game (this is then registered to a modbus in the Titancraft class)
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "titancraft");

	// These were created for my making blocks tutorial doc
	// DELETE when everyone understands how to create blocks (also delete en_us.json line associated with these items, and associated blockstate, model, blockitem and texture json files
	public static final RegistryObject<BlockLandmine> LANDMINE_SAND = BLOCKS.register("landmine_sand", BlockLandmine::new);
	public static final RegistryObject<BlockLandmine> LANDMINE_GRASS = BLOCKS.register("landmine_grass", BlockLandmine::new);
	public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> ALUMINIUM_ORE = BLOCKS.register("aluminium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
	public static final RegistryObject<Block> ALUMINIUM_BLOCK = BLOCKS.register("aluminium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
}
