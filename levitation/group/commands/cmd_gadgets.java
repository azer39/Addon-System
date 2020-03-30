package levitation.group.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import levitation.group.main;
import levitation.group.utils.item_manager;

public class cmd_gadgets implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			openStanInv(p);
		}
		
		
		return true;
	}
	
	public static void openStanInv(Player p) {
		
		Inventory inv = main.instance.getServer().createInventory(null, 27, "§eGadget System");
		
		item_manager.addItem(inv, Material.LEATHER_BOOTS, 1, "§6Boots", 11);
		item_manager.addItem(inv, Material.BLAZE_POWDER, 1, "§cParticels", 13);
		item_manager.addItem(inv, Material.SKULL_ITEM, 1, "§5Heads", 15);
		
		
		p.closeInventory();
		p.openInventory(inv);
	}

}

/*
 
		item_manager.addItem(inv, Material.LAVA_BUCKET, 1, "§cLAVA", 10);
		item_manager.addItem(inv, Material.WATER_BUCKET, 1, "§9WATER", 12);
		//item_manager.addItem(inv, Material.WEB, 1, "§7CLOUD", 14);
		item_manager.addItem(inv, Material.OBSIDIAN, 1, "§1OBSIDIAN", 16);
		item_manager.addItem(inv, Material.TORCH, 1, "§cFIRE", 20);
		item_manager.addItem(inv, Material.REDSTONE, 1, "§cREDSTONE", 22);
		item_manager.addItem(inv, Material.RED_MUSHROOM, 1, "§cHEART", 24);

*/