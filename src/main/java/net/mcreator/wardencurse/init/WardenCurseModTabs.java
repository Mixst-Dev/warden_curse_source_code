
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wardencurse.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.wardencurse.WardenCurseMod;

public class WardenCurseModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WardenCurseMod.MODID);
	public static final RegistryObject<CreativeModeTab> SEKIRO_BLOCKS = REGISTRY.register("sekiro_blocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.warden_curse.sekiro_blocks")).icon(() -> new ItemStack(WardenCurseModBlocks.TOUGH_FIR_LOG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_WOOD.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_LOG.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_LEAVES.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_PLANKS.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_STAIRS.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_SLAB.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_FENCE.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_FENCE_GATE.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_PLANKS_TREATED.get().asItem());
				tabData.accept(WardenCurseModBlocks.TUNG_FIR_STAIRS.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_SLABS.get().asItem());
				tabData.accept(WardenCurseModBlocks.TUNG_FIRE_FENCE.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_GATE.get().asItem());
				tabData.accept(WardenCurseModBlocks.FIR_DOOR.get().asItem());
				tabData.accept(WardenCurseModBlocks.TOUGH_FIR_TILES.get().asItem());
				tabData.accept(WardenCurseModBlocks.TARGETBOARD.get().asItem());
				tabData.accept(WardenCurseModBlocks.WALL_BLOCK.get().asItem());
				tabData.accept(WardenCurseModBlocks.WALL_BLOCK_DAMAGED.get().asItem());
				tabData.accept(WardenCurseModBlocks.WALL_DAMAGED.get().asItem());
				tabData.accept(WardenCurseModBlocks.METALIC_FRAME.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> MATERIALS = REGISTRY.register("materials",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.warden_curse.materials")).icon(() -> new ItemStack(WardenCurseModItems.AZURE_LAZULITE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(WardenCurseModBlocks.PROSTHETIC_TABLE_BLOCK.get().asItem());
				tabData.accept(WardenCurseModBlocks.ADAMANTITE_ORE.get().asItem());
				tabData.accept(WardenCurseModBlocks.MAGENTITE_ORE.get().asItem());
				tabData.accept(WardenCurseModBlocks.LARGE_COBBLESTONE.get().asItem());
				tabData.accept(WardenCurseModBlocks.LARGE_COBBLE_STONE_STAIRS.get().asItem());
				tabData.accept(WardenCurseModBlocks.LARGE_COBBLESTONE_SLAB.get().asItem());
				tabData.accept(WardenCurseModItems.ADAMANTITE_SCRAP.get());
				tabData.accept(WardenCurseModItems.IRON_SCRAP.get());
				tabData.accept(WardenCurseModItems.MAGNETITE_SCRAP.get());
				tabData.accept(WardenCurseModItems.BLACK_GUNPOWDER.get());
				tabData.accept(WardenCurseModItems.YELLOW_GUNPOWDER.get());
				tabData.accept(WardenCurseModItems.FULIMATED_MERCURY.get());
				tabData.accept(WardenCurseModItems.AZURE_LAZULITE.get());
				tabData.accept(WardenCurseModItems.TOUGH_LEATHER.get());
				tabData.accept(WardenCurseModItems.PROSTHETIC_MECHANISM.get());
				tabData.accept(WardenCurseModItems.SCULK_INFESTED_BONES.get());
				tabData.accept(WardenCurseModItems.ANCIENT_CLAW.get());
				tabData.accept(WardenCurseModItems.LUMP_OF_FAT_WAX.get());
				tabData.accept(WardenCurseModItems.FLAME_BARREL.get());
				tabData.accept(WardenCurseModItems.RUSTED_SABIMARU.get());
				tabData.accept(WardenCurseModItems.SHINOBI_AXE_OF_THE_MONKEY.get());
				tabData.accept(WardenCurseModItems.ROBERT_FIRECRACKERS.get());
				tabData.accept(WardenCurseModItems.GYOUBUS_HORN.get());
				tabData.accept(WardenCurseModItems.SHURIKEN_WHEEL.get());
				tabData.accept(WardenCurseModBlocks.TOUGH_SHALE.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> SEKIRO = REGISTRY.register("sekiro",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.warden_curse.sekiro")).icon(() -> new ItemStack(WardenCurseModItems.REALMORTALBLADE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(WardenCurseModItems.SEKIROBOOK.get());
				tabData.accept(WardenCurseModItems.SPIRITEMBLEMITEM.get());
				tabData.accept(WardenCurseModItems.MORTALBLADE.get());
				tabData.accept(WardenCurseModItems.REALMORTALBLADE.get());
				tabData.accept(WardenCurseModItems.YASHARIKU_SUGAR.get());
				tabData.accept(WardenCurseModItems.YASHARIKU_SPIRIT_FALL.get());
				tabData.accept(WardenCurseModItems.AKOSUGAR.get());
				tabData.accept(WardenCurseModItems.AKOSPIRITFALL.get());
				tabData.accept(WardenCurseModItems.GOKANSUGAR.get());
				tabData.accept(WardenCurseModItems.GOKAN_SPIRIT_FALL.get());
				tabData.accept(WardenCurseModItems.UNGO_SUGARITEM.get());
				tabData.accept(WardenCurseModItems.UNGO_SPIRIT_FALL.get());
				tabData.accept(WardenCurseModItems.CEREMONIAL_TANTO.get());
				tabData.accept(WardenCurseModItems.HEALINGBOTTLE.get());
				tabData.accept(WardenCurseModItems.PELLETS.get());
				tabData.accept(WardenCurseModItems.DIVINE_CONFETTI.get());
				tabData.accept(WardenCurseModItems.SHRIEKING_GLASS.get());
				tabData.accept(WardenCurseModItems.MISFORTUNED_SCULK_SPLINTER.get());
				tabData.accept(WardenCurseModItems.FLOATING_PASSAGE.get());
				tabData.accept(WardenCurseModItems.WHIRLWINDSLASHSKILL.get());
				tabData.accept(WardenCurseModItems.SHADOWRUSHSKILL.get());
				tabData.accept(WardenCurseModItems.SAKURADANCESKILL.get());
				tabData.accept(WardenCurseModItems.ASHINACROSSKSILL.get());
				tabData.accept(WardenCurseModItems.DRAGONFLASHSKILL.get());
				tabData.accept(WardenCurseModItems.SPIRALCLOUDPASSAGESKILL.get());
				tabData.accept(WardenCurseModItems.ONEMINDSKILL.get());
				tabData.accept(WardenCurseModItems.ICHIMONJI.get());
				tabData.accept(WardenCurseModItems.MORTALDRAWSKILL.get());
				tabData.accept(WardenCurseModItems.AGEDMISTRAVENITEM.get());
				tabData.accept(WardenCurseModItems.LOADED_AXE_ITEM.get());
				tabData.accept(WardenCurseModItems.SPARKINGAHHAXZE.get());
				tabData.accept(WardenCurseModItems.LAZULITEAXEICON.get());
				tabData.accept(WardenCurseModItems.FIREVENT_1.get());
				tabData.accept(WardenCurseModItems.LAZULITEVENT.get());
				tabData.accept(WardenCurseModItems.CURSEDVENT_1.get());
				tabData.accept(WardenCurseModItems.LOADEDSPEARICON.get());
				tabData.accept(WardenCurseModItems.LEAPINGFLAME.get());
				tabData.accept(WardenCurseModItems.SHINOBIFIRECRACKER.get());
				tabData.accept(WardenCurseModItems.LONGSPARK.get());
				tabData.accept(WardenCurseModItems.PURPLEFUME.get());
				tabData.accept(WardenCurseModItems.SHURIKENSKILL.get());
				tabData.accept(WardenCurseModItems.LAZULITESHURIKENSKILL.get());
				tabData.accept(WardenCurseModItems.DPSTESTER_SPAWN_EGG.get());
				tabData.accept(WardenCurseModItems.ASHINASOLDIER_SPAWN_EGG.get());
				tabData.accept(WardenCurseModItems.ASHINA_SOLDIER_2_SPAWN_EGG.get());
				tabData.accept(WardenCurseModItems.ASHINA_SPEAR_SPAWN_EGG.get());
				tabData.accept(WardenCurseModItems.GENERAL_NAOMI_KAWARADA_SPAWN_EGG.get());
				tabData.accept(WardenCurseModItems.ANCIENT_SKULK_VESSLE_SPAWN_EGG.get());
				tabData.accept(WardenCurseModItems.OIL.get());
				tabData.accept(WardenCurseModItems.TESTSF.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> OUTFITS = REGISTRY.register("outfits",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.warden_curse.outfits")).icon(() -> new ItemStack(WardenCurseModItems.SEKIRO_GEAR_CUSTOM_3_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(WardenCurseModItems.SHURA_HEAD_HELMET.get());
				tabData.accept(WardenCurseModItems.SHURA_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.SHURA_LEGGINGS.get());
				tabData.accept(WardenCurseModItems.SHURA_BOOTS.get());
				tabData.accept(WardenCurseModItems.SEKIROARMOR_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.SEKIROARMOR_LEGGINGS.get());
				tabData.accept(WardenCurseModItems.SEKIROARMOR_BOOTS.get());
				tabData.accept(WardenCurseModItems.SEKIROARMOR_2_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.SEKIROARMOR_2_LEGGINGS.get());
				tabData.accept(WardenCurseModItems.SEKIROARMOR_2_BOOTS.get());
				tabData.accept(WardenCurseModItems.SEKIRO_CUSTOM_GEAR_4_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.SEKIRO_GEAR_CUSTOM_3_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.SEKIRO_GEAR_CUSTOM_2_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.SEKIRO_GEAR_CUSTOM_1_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.SEKRIO_GEAR_CUSTOM_LEGGINGS.get());
				tabData.accept(WardenCurseModItems.SEKRIO_GEAR_CUSTOM_BOOTS.get());
				tabData.accept(WardenCurseModItems.IGRIZSIRO_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.IGRIZSIRO_LEGGINGS.get());
				tabData.accept(WardenCurseModItems.IGRIZSIRO_BOOTS.get());
				tabData.accept(WardenCurseModItems.BLACKLEATHER_ARMOR_CHESTPLATE.get());
				tabData.accept(WardenCurseModItems.BLACKLEATHER_ARMOR_LEGGINGS.get());
				tabData.accept(WardenCurseModItems.BLACKLEATHER_ARMOR_BOOTS.get());
			})

					.build());
}
