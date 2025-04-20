
package net.mcreator.wardencurse.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class LargeCobblestoneSlabBlock extends SlabBlock {
	public LargeCobblestoneSlabBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE).strength(4f, 14f).requiresCorrectToolForDrops().dynamicShape());
	}
}
