
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.wardencurse.block.entity.ProstheticTableBlockBlockEntity;
import net.mcreator.wardencurse.WardenCurseMod;

public class WardenCurseModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WardenCurseMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PROSTHETIC_TABLE_BLOCK = register("prosthetic_table_block", WardenCurseModBlocks.PROSTHETIC_TABLE_BLOCK, ProstheticTableBlockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
