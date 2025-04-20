
package net.mcreator.wardencurse.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BlackGunpowderItem extends Item {
	public BlackGunpowderItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
