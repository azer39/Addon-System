package levitation.group.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import levitation.group.utils.boots_player;

public class event_flightattempt implements Listener{
	
	@EventHandler
	public void onFlightAttempt(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		
		if(p.getGameMode() != GameMode.CREATIVE) {
			
			for(boots_player bp : boots_player.bootsPlayers) {
				if(bp.p == p) {
					
					if(bp.id == 2) {
						double distance = getDistance(p);
						if(distance < 3) {
							p.setVelocity(p.getVelocity().add(new Vector(0, 0.5, 0)));
							Bukkit.getWorld(p.getWorld().getName()).playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 10, 1);
						}
					}

					
					p.setFlying(false);
					e.setCancelled(true);
				}
			}


			
		}
		
		p.setFlying(false);
		e.setCancelled(true);
		
	}
    public static int getDistance(Player e){
        Location loc = e.getLocation().clone();
        double y = loc.getBlockY();
        int distance = 0;
        for (double i = y; i >= 0; i--){
            loc.setY(i);
           if(loc.getBlock().getType().isSolid())break;
            distance++;
        }
        return distance;
    }

}
