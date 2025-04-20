
package net.mcreator.wardencurse.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LumpOfFatWaxItem extends Item {
	public LumpOfFatWaxItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
