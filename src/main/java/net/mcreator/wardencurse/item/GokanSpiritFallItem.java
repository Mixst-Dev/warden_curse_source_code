
package net.mcreator.wardencurse.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.wardencurse.procedures.GokanSpiritFallRightclickedProcedure;

import java.util.List;

public class GokanSpiritFallItem extends Item {
	public GokanSpiritFallItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A7bDuration: \u00A7b30 \u00A7bseconds."));
		list.add(Component.literal("\u00A7bCost: \u00A7b1 \u00A7bemblem."));
		list.add(Component.literal("\u00A7a+ \u00A7aReduces \u00A7aposture \u00A7adamage \u00A7aby \u00A7a67%"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GokanSpiritFallRightclickedProcedure.execute(world, entity);
		return ar;
	}
}
