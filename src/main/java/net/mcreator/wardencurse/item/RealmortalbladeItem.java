
package net.mcreator.wardencurse.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class RealmortalbladeItem extends Item {
	public RealmortalbladeItem() {
		super(new Item.Properties().durability(7000).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A74An \u00A74ancient \u00A74blade \u00A74forged \u00A74from \u00A74the \u00A74blood \u00A74of \u00A74a \u00A74long \u00A74forgotten \u00A74god."));
	}
}
