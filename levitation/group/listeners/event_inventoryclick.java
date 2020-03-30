package levitation.group.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import levitation.group.main;
import levitation.group.commands.cmd_gadgets;
import levitation.group.utils.boots_player;
import levitation.group.utils.gadget_player;
import levitation.group.utils.item_manager;
import levitation.group.utils.player_pet;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class event_inventoryclick implements Listener{
	
	
	@EventHandler
	public void onInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		/*
		 * 
		 * Gadget Inventory
		 * 
		 * */

		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getSlot() == 15 && e.getView().getTitle() == "§eGadget System") {
			p.closeInventory();
			
			Inventory headInv = Bukkit.getServer().createInventory(null, 54, "§5Heads");
			addHeads(headInv);
			
			p.openInventory(headInv);
		}
		
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getSlot() == 13 && e.getView().getTitle() == "§eGadget System") {
			p.closeInventory();
			
			Inventory particels = Bukkit.getServer().createInventory(null, 45, "§cParticels");
			addParticels(particels);
			
			p.openInventory(particels);
		}
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getSlot() == 30 && e.getView().getTitle() == "§eGadget System") {
			p.closeInventory();
			
			Inventory animals = Bukkit.getServer().createInventory(null, 54, "§aAnimals");
			addAnimals(animals);
			
			p.openInventory(animals);
		}
		
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getSlot() == 11 && e.getView().getTitle() == "§eGadget System") {
			p.closeInventory();
			
			Inventory bootsInv = Bukkit.getServer().createInventory(null, 9, "§6Boots");

	        ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta lch = (LeatherArmorMeta)lboots.getItemMeta();
	        lch.setColor(Color.fromRGB(0, 128, 0));
	        lch.setDisplayName("§aJump Boots");
	        lboots.setItemMeta(lch);
	        

	        ItemStack iboots = new ItemStack(Material.LEATHER_BOOTS, 1);
	        LeatherArmorMeta ich = (LeatherArmorMeta)iboots.getItemMeta();
	        ich.setColor(Color.fromRGB(0, 255, 255));
	        ich.setDisplayName("§bIce Boots");
	        iboots.setItemMeta(ich);
			
	        bootsInv.setItem(1, lboots);
	        bootsInv.setItem(3, iboots);
			addBoots(bootsInv);
			
			p.openInventory(bootsInv);
		}
		
		

		
		
		
		/*
		 *
		 * Bootsmenu
		 * 
		 */
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getView().getTitle() == "§6Boots") {
			
			removeBootPlayerList(p);
			restoreDefaults(p);
			
			if(e.getSlot() == 0) {
				p.getEquipment().clear();
				p.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
				
				p.setWalkSpeed(1F);
				
				p.sendMessage(main.prefix + "§aDu hast die §eSpeed Boots §aausgerüstet!");
			}else if(e.getSlot() == 1) {
				
				//gadget_player.jumpBoots.add(p);
				
				boots_player bp = new boots_player(p, Material.LEATHER_BOOTS, 2);
				boots_player.bootsPlayers.add(bp);
				
		        ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS, 1);
		        LeatherArmorMeta lch = (LeatherArmorMeta)lboots.getItemMeta();
		        lch.setColor(Color.fromRGB(0, 128, 0));
		        lch.setDisplayName("§aJump Boots");
		        lboots.setItemMeta(lch);
		        
		        p.getEquipment().setBoots(lboots);
		        
		        
		        
		        p.setAllowFlight(true);
				
				p.sendMessage(main.prefix + "§aDu hast die §2Jump Boots §aausgerüstet!");
			}else if(e.getSlot() == 2) {				
				p.getEquipment().clear();
				p.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
				p.setAllowFlight(true);
				p.setFlying(true);
				
				p.sendMessage(main.prefix + "§aDu hast die §cFly Boots §aausgerüstet!");
			}else if(e.getSlot() == 3) {
				
				//gadget_player.iceBoots.add(p);
				
				boots_player bp = new boots_player(p, Material.LEATHER_BOOTS, 1);
				boots_player.bootsPlayers.add(bp);
				
		        ItemStack iboots = new ItemStack(Material.LEATHER_BOOTS, 1);
		        LeatherArmorMeta ich = (LeatherArmorMeta)iboots.getItemMeta();
		        ich.setColor(Color.fromRGB(0, 255, 255));
		        ich.setDisplayName("§bIce Boots");
		        iboots.setItemMeta(ich);
		        
		        p.getEquipment().setBoots(iboots);
				
				
				p.sendMessage(main.prefix + "§aDu hast die §bIce Boots §aausgerüstet!");
			}else if(e.getSlot() == 4) {
				p.getEquipment().setBoots(null);
				
		        ItemStack iboots = new ItemStack(Material.DIAMOND_BOOTS, 1);
		        ItemMeta ich = iboots.getItemMeta();

		        ich.addEnchant(Enchantment.WATER_WORKER, 1, true);
		        ich.setDisplayName("§9Gucci Boots");
		        iboots.setItemMeta(ich);
				
				p.getEquipment().setBoots(iboots);				
				gadget_player pp = new gadget_player(p, Effect.SPELL);
				gadget_player.players.add(pp);
				
				p.sendMessage(main.prefix + "§aDu hast die §9Gucci Boots §aausgerüstet!");
			}
			else if(e.getSlot() == 8) {
				
				if(p.getEquipment().getBoots() != null) {
					removeBootPlayerList(p);
					p.getEquipment().setBoots(null);
					p.sendMessage(main.prefix + "§cDu hast deine Schuhe ausgezogen!");
					p.closeInventory();
				}
			}
			
			if(e.getSlot() != 8) {
				p.closeInventory();
			}
		}
		
		/*
		 * 
		 * Particel Inventory
		 * 
		 * */
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getView().getTitle() == "§cParticels") {
			
			try {
				switch (e.getCurrentItem().getType()) {
				case LAVA_BUCKET:
					
					removeGadgetPlayerList(p);
					
					gadget_player lavaP = new gadget_player(p, Effect.LAVA_POP);
					gadget_player.players.add(lavaP);

					break;
				
				case WATER_BUCKET:
					
					removeGadgetPlayerList(p);
					
					gadget_player waterP = new gadget_player(p, Effect.WATERDRIP);
					gadget_player.players.add(waterP);

					break;
					
				case WEB:
					
					removeGadgetPlayerList(p);
					
					gadget_player webP = new gadget_player(p, Effect.CLOUD);
					gadget_player.players.add(webP);

					break;
					
					
				case OBSIDIAN:
					
					removeGadgetPlayerList(p);
					
					gadget_player obsP = new gadget_player(p, Effect.PARTICLE_SMOKE);
					gadget_player.players.add(obsP);

					break;
				
				case TORCH:
					
					removeGadgetPlayerList(p);
					
					gadget_player torchP = new gadget_player(p, Effect.FIREWORKS_SPARK);
					gadget_player.players.add(torchP);

					break;
					
				case REDSTONE:
					
					removeGadgetPlayerList(p);
					
					gadget_player redP = new gadget_player(p, Effect.COLOURED_DUST);
					gadget_player.players.add(redP);

					break;

				case RED_MUSHROOM:
					
					removeGadgetPlayerList(p);
					
					gadget_player mushP = new gadget_player(p, Effect.EXPLOSION);
					gadget_player.players.add(mushP);

					break;
					
				case EXP_BOTTLE:
					
					removeGadgetPlayerList(p);
					
					gadget_player xpP = new gadget_player(p, Effect.WITCH_MAGIC);
					gadget_player.players.add(xpP);

					break;
					
				case ENDER_PEARL:
					
					removeGadgetPlayerList(p);
					
					gadget_player endP = new gadget_player(p, Effect.ENDER_SIGNAL);
					gadget_player.players.add(endP);

					break;
					
				case ENCHANTMENT_TABLE:
					
					removeGadgetPlayerList(p);
					
					gadget_player instSpell = new gadget_player(p, Effect.INSTANT_SPELL);
					gadget_player.players.add(instSpell);

					break;
					
				case FLINT_AND_STEEL:
					
					removeGadgetPlayerList(p);
					
					gadget_player fireP = new gadget_player(p, Effect.FLAME);
					gadget_player.players.add(fireP);

					break;
					
				case BARRIER:

					cmd_gadgets.openStanInv(p);
					
					break;
				default:
					break;
				}
				
				if(e.getCurrentItem().getType() != Material.BARRIER) {
					p.closeInventory();
				}
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			

			
			for(gadget_player puu : gadget_player.players) {
				System.out.println(puu.p.getName());
			}
			
		}
		
		/*
		 *
		 * Headmenu
		 * 
		 */
		
		if(!(e.getAction() == InventoryAction.NOTHING) && e.getView().getTitle() == "§5Heads") {
			
			if(e.getCurrentItem().getType() != Material.STAINED_GLASS_PANE) {
				
				if(e.getCurrentItem().getType() == Material.BARRIER) {
					cmd_gadgets.openStanInv(p);
					e.setCancelled(true);
					return;
				}
				
				if(e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
					p.getEquipment().setHelmet(null);			
					e.setCancelled(true);
					p.closeInventory();
					return;
				}
				
				p.getEquipment().setHelmet(null);
				p.getEquipment().setHelmet(new ItemStack(e.getCurrentItem().getType(), 1));
				p.closeInventory();
			}
		}	
		e.setCancelled(true);
	}
	
	public void addParticels(Inventory inv) {
		
		for(int i = 0; i < 45; i++) {
			inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15));
		}
		
		
		item_manager.addItem(inv, Material.LAVA_BUCKET, 1, "§cLAVA", 10);
		item_manager.addItem(inv, Material.WATER_BUCKET, 1, "§9WATER", 12);
		item_manager.addItem(inv, Material.WEB, 1, "§7CLOUD", 14);
		item_manager.addItem(inv, Material.OBSIDIAN, 1, "§1OBSIDIAN", 16);
		
		item_manager.addItem(inv, Material.TORCH, 1, "§cFIRE", 20);
		item_manager.addItem(inv, Material.REDSTONE, 1, "§cREDSTONE", 22);
		item_manager.addItem(inv, Material.RED_MUSHROOM, 1, "§cHEART", 24);
		
		item_manager.addItem(inv, Material.EXP_BOTTLE, 1, "§5XP", 28);
		item_manager.addItem(inv, Material.ENDER_PEARL, 1, "§9END", 30);
		item_manager.addItem(inv, Material.ENCHANTMENT_TABLE, 1, "§dINSTANT SPELL", 32);
		item_manager.addItem(inv, Material.FLINT_AND_STEEL, 1, "§cFLAME", 34);
		
		item_manager.addItem(inv, Material.BARRIER, 1, "§4BACK", 44);
	}
	
	public void addBoots(Inventory inv) {
		item_manager.addItem(inv, Material.GOLD_BOOTS, 1, "§eSpeed Boots", 0); //KMDD
		item_manager.addItem(inv, Material.DIAMOND_BOOTS, 1, "§9Gucci Boots", 4); //KMDD
		item_manager.addItem(inv, Material.IRON_BOOTS, 1, "§cFly Boots", 2); //KMDD
		
		item_manager.addItem(inv, Material.BARRIER, 1, "§4Remove Boots", 8);
	}
	
	public void removeGadgetPlayerList(Player p) {
		
		List<gadget_player> backUp = new ArrayList<gadget_player>();
		backUp = gadget_player.players;
		
		gadget_player.players.clear();
		
		for(gadget_player gp : backUp) {
			if(gp.p.getName() != p.getName()) {
				gadget_player.players.add(gp);
			}
		}		
	}
	
	public void removeBootPlayerList(Player p) {
		List<boots_player> bckUp = new ArrayList<boots_player>();
		bckUp = boots_player.bootsPlayers;
		
		boots_player.bootsPlayers.clear();
		
		for(boots_player bp : bckUp) {
			if(bp.p.getName() != p.getName()) {
				boots_player.bootsPlayers.add(bp);
			}
		}
	}
	
	public void removeAnimal(Player p) {
		List<player_pet> bckUp = new ArrayList<player_pet>();
		bckUp = player_pet.animalList;
		
		player_pet.animalList.clear();
		
		for(player_pet bp : bckUp) {
			if(bp.p.getName() != p.getName()) {
				player_pet.animalList.add(bp);
			}
		}
	}
	
	public void restoreDefaults(Player p) {
		p.setFlying(false);
		p.setAllowFlight(false);
		p.getEquipment().clear();
		gadget_player.iceBoots.remove(p);
		gadget_player.jumpBoots.remove(p);
		p.setWalkSpeed(0.2F);
	}
	

	
	public static ItemStack getCustomHead(OfflinePlayer p) {
		org.bukkit.inventory.ItemStack Skull = new ItemStack(Material.SKULL_ITEM,1 , (short) SkullType.PLAYER.ordinal());
		
		org.bukkit.inventory.meta.SkullMeta skullMeta = (org.bukkit.inventory.meta.SkullMeta) Skull.getItemMeta();
		skullMeta.setDisplayName("§b" + p.getName());
		skullMeta.setOwner(p.getName());
		Skull.setItemMeta(skullMeta);
		
		return Skull;
	}
	
	@SuppressWarnings("deprecation")
	public static void addAnimals(Inventory inv) {
		inv.setItem(0, new ItemStack((Material.MONSTER_EGG), 1, EntityType.PIG.getTypeId()));
		inv.setItem(1, new ItemStack((Material.MONSTER_EGG), 1, EntityType.SHEEP.getTypeId()));
		inv.setItem(2, new ItemStack((Material.MONSTER_EGG), 1, EntityType.COW.getTypeId()));
		inv.setItem(3, new ItemStack((Material.MONSTER_EGG), 1, EntityType.CHICKEN.getTypeId()));
		inv.setItem(4, new ItemStack((Material.MONSTER_EGG), 1, EntityType.WOLF.getTypeId()));
		inv.setItem(5, new ItemStack((Material.MONSTER_EGG), 1, EntityType.MUSHROOM_COW.getTypeId()));
		inv.setItem(6, new ItemStack((Material.MONSTER_EGG), 1, EntityType.OCELOT.getTypeId()));
		inv.setItem(7, new ItemStack((Material.MONSTER_EGG), 1, EntityType.HORSE.getTypeId()));
		inv.setItem(8, new ItemStack((Material.MONSTER_EGG), 1, EntityType.RABBIT.getTypeId()));
	}
	
	@SuppressWarnings("deprecation")
	public static void addHeads(Inventory inv) {
		
		
		for(int i = 0; i < 54; i++) {
			inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15));
		}
		
		
		inv.setItem(1, getCustomHead(Bukkit.getOfflinePlayer("UBCAzer")));
		item_manager.addItem(inv, Material.CHEST, 1, "§eChest", 3);
		item_manager.addItem(inv, Material.TNT, 1, "§4TNT", 5);
		item_manager.addItem(inv, Material.DROPPER, 1, "§7Dropper", 7);
		
		item_manager.addItem(inv, Material.DISPENSER, 1, "§7Dispensre", 9);
		item_manager.addItem(inv, Material.MINECART, 1, "§8Minecart", 11);
		item_manager.addItem(inv, Material.NOTE_BLOCK, 1, "§fNoteblock", 13);
		item_manager.addItem(inv, Material.FURNACE, 1, "§8Furnace", 15);
		item_manager.addItem(inv, Material.LEAVES, 1, "§aLeaves", 17);
		
		item_manager.addItem(inv, Material.ENCHANTMENT_TABLE, 1, "§dEnchantment Tabel", 19);
		item_manager.addItem(inv, Material.ENDER_PORTAL_FRAME, 1, "§5End Portal", 21);
		item_manager.addItem(inv, Material.ENDER_CHEST, 1, "§5Ender Chest", 23);
		item_manager.addItem(inv, Material.BEACON, 1, "§bBeacon", 25);
		
		item_manager.addItem(inv, Material.REDSTONE_LAMP_OFF, 1, "§cRedstone Lamp Off", 27);
		item_manager.addItem(inv, Material.REDSTONE_BLOCK, 1, "§cRedstone Block", 29);
		item_manager.addItem(inv, Material.PISTON_BASE, 1, "§fPiston", 31);
		item_manager.addItem(inv, Material.ANVIL, 1, "§7Anvil", 33);
		item_manager.addItem(inv, Material.SLIME_BLOCK, 1, "§aSlime", 35);
		
		item_manager.addItem(inv, Material.BEDROCK, 1, "§0Bedrock", 37);
		item_manager.addItem(inv, Material.BOOKSHELF, 1, "§eBookshelf", 39);
		item_manager.addItem(inv, Material.ICE, 1, "§bIce", 41);
		item_manager.addItem(inv, Material.PUMPKIN, 1, "§6Pumpkin", 43);
		
		
		item_manager.addItem(inv, Material.LAVA_BUCKET, 1, "§4Remove Head", 45);
		item_manager.addItem(inv, Material.BARRIER, 1, "§4BACK", 53);
	}

}
