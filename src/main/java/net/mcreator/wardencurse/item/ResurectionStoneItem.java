
package net.mcreator.wardencurse.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ResurectionStoneItem extends Item {
	public ResurectionStoneItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}
