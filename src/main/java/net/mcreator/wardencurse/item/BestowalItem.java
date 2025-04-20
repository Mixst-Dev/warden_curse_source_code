
package net.mcreator.wardencurse.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BestowalItem extends Item {
	public BestowalItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
