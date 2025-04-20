
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.wardencurse.block.WallDamagedBlock;
import net.mcreator.wardencurse.block.WallBlockDamagedBlock;
import net.mcreator.wardencurse.block.WallBlockBlock;
import net.mcreator.wardencurse.block.TungFireFenceBlock;
import net.mcreator.wardencurse.block.TungFirStairsBlock;
import net.mcreator.wardencurse.block.Tough_FirWoodBlock;
import net.mcreator.wardencurse.block.Tough_FirStairsBlock;
import net.mcreator.wardencurse.block.Tough_FirSlabBlock;
import net.mcreator.wardencurse.block.Tough_FirPlanksBlock;
import net.mcreator.wardencurse.block.Tough_FirLogBlock;
import net.mcreator.wardencurse.block.Tough_FirLeavesBlock;
import net.mcreator.wardencurse.block.Tough_FirFenceGateBlock;
import net.mcreator.wardencurse.block.Tough_FirFenceBlock;
import net.mcreator.wardencurse.block.ToughShaleBlock;
import net.mcreator.wardencurse.block.ToughFirTilesBlock;
import net.mcreator.wardencurse.block.ToughFirSlabsBlock;
import net.mcreator.wardencurse.block.ToughFirPlanksTreatedBlock;
import net.mcreator.wardencurse.block.ToughFirGateBlock;
import net.mcreator.wardencurse.block.TargetboardBlock;
import net.mcreator.wardencurse.block.ProstheticTableBlockBlock;
import net.mcreator.wardencurse.block.MetalicFrameBlock;
import net.mcreator.wardencurse.block.MagentiteOreBlock;
import net.mcreator.wardencurse.block.LargeCobblestoneSlabBlock;
import net.mcreator.wardencurse.block.LargeCobblestoneBlock;
import net.mcreator.wardencurse.block.LargeCobbleStoneStairsBlock;
import net.mcreator.wardencurse.block.FirDoorBlock;
import net.mcreator.wardencurse.block.AdamantiteOreBlock;
import net.mcreator.wardencurse.WardenCurseMod;

public class WardenCurseModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, WardenCurseMod.MODID);
	public static final RegistryObject<Block> PROSTHETIC_TABLE_BLOCK = REGISTRY.register("prosthetic_table_block", () -> new ProstheticTableBlockBlock());
	public static final RegistryObject<Block> ADAMANTITE_ORE = REGISTRY.register("adamantite_ore", () -> new AdamantiteOreBlock());
	public static final RegistryObject<Block> MAGENTITE_ORE = REGISTRY.register("magentite_ore", () -> new MagentiteOreBlock());
	public static final RegistryObject<Block> LARGE_COBBLESTONE = REGISTRY.register("large_cobblestone", () -> new LargeCobblestoneBlock());
	public static final RegistryObject<Block> LARGE_COBBLE_STONE_STAIRS = REGISTRY.register("large_cobble_stone_stairs", () -> new LargeCobbleStoneStairsBlock());
	public static final RegistryObject<Block> LARGE_COBBLESTONE_SLAB = REGISTRY.register("large_cobblestone_slab", () -> new LargeCobblestoneSlabBlock());
	public static final RegistryObject<Block> TOUGH_SHALE = REGISTRY.register("tough_shale", () -> new ToughShaleBlock());
	public static final RegistryObject<Block> TOUGH_FIR_WOOD = REGISTRY.register("tough_fir_wood", () -> new Tough_FirWoodBlock());
	public static final RegistryObject<Block> TOUGH_FIR_LOG = REGISTRY.register("tough_fir_log", () -> new Tough_FirLogBlock());
	public static final RegistryObject<Block> TOUGH_FIR_PLANKS = REGISTRY.register("tough_fir_planks", () -> new Tough_FirPlanksBlock());
	public static final RegistryObject<Block> TOUGH_FIR_LEAVES = REGISTRY.register("tough_fir_leaves", () -> new Tough_FirLeavesBlock());
	public static final RegistryObject<Block> TOUGH_FIR_STAIRS = REGISTRY.register("tough_fir_stairs", () -> new Tough_FirStairsBlock());
	public static final RegistryObject<Block> TOUGH_FIR_SLAB = REGISTRY.register("tough_fir_slab", () -> new Tough_FirSlabBlock());
	public static final RegistryObject<Block> TOUGH_FIR_FENCE = REGISTRY.register("tough_fir_fence", () -> new Tough_FirFenceBlock());
	public static final RegistryObject<Block> TOUGH_FIR_FENCE_GATE = REGISTRY.register("tough_fir_fence_gate", () -> new Tough_FirFenceGateBlock());
	public static final RegistryObject<Block> WALL_BLOCK = REGISTRY.register("wall_block", () -> new WallBlockBlock());
	public static final RegistryObject<Block> WALL_BLOCK_DAMAGED = REGISTRY.register("wall_block_damaged", () -> new WallBlockDamagedBlock());
	public static final RegistryObject<Block> TOUGH_FIR_PLANKS_TREATED = REGISTRY.register("tough_fir_planks_treated", () -> new ToughFirPlanksTreatedBlock());
	public static final RegistryObject<Block> TOUGH_FIR_SLABS = REGISTRY.register("tough_fir_slabs", () -> new ToughFirSlabsBlock());
	public static final RegistryObject<Block> TOUGH_FIR_GATE = REGISTRY.register("tough_fir_gate", () -> new ToughFirGateBlock());
	public static final RegistryObject<Block> FIR_DOOR = REGISTRY.register("fir_door", () -> new FirDoorBlock());
	public static final RegistryObject<Block> TUNG_FIR_STAIRS = REGISTRY.register("tung_fir_stairs", () -> new TungFirStairsBlock());
	public static final RegistryObject<Block> TUNG_FIRE_FENCE = REGISTRY.register("tung_fire_fence", () -> new TungFireFenceBlock());
	public static final RegistryObject<Block> WALL_DAMAGED = REGISTRY.register("wall_damaged", () -> new WallDamagedBlock());
	public static final RegistryObject<Block> TARGETBOARD = REGISTRY.register("targetboard", () -> new TargetboardBlock());
	public static final RegistryObject<Block> TOUGH_FIR_TILES = REGISTRY.register("tough_fir_tiles", () -> new ToughFirTilesBlock());
	public static final RegistryObject<Block> METALIC_FRAME = REGISTRY.register("metalic_frame", () -> new MetalicFrameBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
