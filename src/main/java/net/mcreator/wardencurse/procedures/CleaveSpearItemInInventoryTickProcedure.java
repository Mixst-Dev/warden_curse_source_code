package net.mcreator.wardencurse.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.wardencurse.init.WardenCurseModItems;

public class CleaveSpearItemInInventoryTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == WardenCurseModItems.CLEAVE_SPEAR.get())) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(WardenCurseModItems.CLEAVE_SPEAR.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1000, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
