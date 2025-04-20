
package net.mcreator.wardencurse.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IronScrapItem extends Item {
	public IronScrapItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
