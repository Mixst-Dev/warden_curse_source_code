
package net.mcreator.wardencurse.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.procedures.SparkingAxeItemInInventoryTickProcedure;

public class LoadedAxeItem extends Item {
	public LoadedAxeItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SparkingAxeItemInInventoryTickProcedure.execute(entity);
	}
}
