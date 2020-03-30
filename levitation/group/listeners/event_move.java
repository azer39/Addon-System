package levitation.group.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import levitation.group.main;
import levitation.group.utils.boots_player;
import levitation.group.utils.gadget_player;
import levitation.group.utils.player_pet;

public class event_move implements Listener{
	
	public static List<Location> locs = new ArrayList<Location>();
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		
		for(gadget_player o : gadget_player.players) {
			if(o.p == p) {
				Location pos = p.getLocation();
				
				pos.getWorld().playEffect(pos, o.e, 30);

			}
		}
		
		for(player_pet animal : player_pet.animalList) {
			
			Location aloc = new Location(animal.p.getWorld(), animal.p.getLocation().getX() + 1, animal.p.getLocation().getY() + 1, animal.p.getLocation().getZ() + 1);
			
			if(!animal.pedSpawned) {
				animal.p.getWorld().spawnEntity(aloc, animal.animal);
			}
						
		}
		
		for(boots_player bp : boots_player.bootsPlayers) {
			if(bp.p == p) {
				switch (bp.m) {
				case LEATHER_BOOTS:
					
					if(bp.id == 1) {
						double x = Math.round(p.getLocation().getX());
						double y = Math.round(p.getLocation().getY());
						double z = Math.round(p.getLocation().getZ());
						
						Location pos = new Location(p.getWorld(), x, y - 1, z);
						
						Block b = p.getWorld().getBlockAt(pos);
						Material old = b.getType();
						if(b.getType() != Material.ICE && b.getType() != Material.AIR && b.getType() != Material.LONG_GRASS && b.getType() != Material.DOUBLE_PLANT) {
							
							b.setType(Material.ICE);
							Bukkit.getScheduler().runTaskLater(main.instance, new Runnable() {
								
								@Override
								public void run() {
									b.setType(old);
									
								}
							},3*20L);
							
						}
					}
					
					break;

				default:
					break;
				}
			}
		}
		
	}
}
