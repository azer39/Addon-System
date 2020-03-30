package levitation.group.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class item_manager {
	
	public static void addItem(org.bukkit.inventory.Inventory inv, Material Material, Integer stackSize, String itemName, Integer position) {
		ItemStack i = new ItemStack(Material, 1);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName(itemName);
		i.setItemMeta(meta);
		
		inv.setItem(position, i);
	}

}
