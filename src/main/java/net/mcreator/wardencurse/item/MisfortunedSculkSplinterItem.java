
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

import net.mcreator.wardencurse.procedures.MSSRightClickedProcedure;

import java.util.List;

public class MisfortunedSculkSplinterItem extends Item {
	public MisfortunedSculkSplinterItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal(
				"\u00A73Gives \u00A73you \u00A73a \u00A73power \u00A73of \u00A73Ancient \u00A73Curses \u00A73by \u00A73causing \u00A73you \u00A73to \u00A73suffer \u00A731\u00A73/\u00A734 \u00A73of \u00A73your \u00A73maximum \u00A73health."));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		MSSRightClickedProcedure.execute(world, entity);
		return ar;
	}
}
