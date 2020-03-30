package levitation.group.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class player_pet {
	
	public Player p;
	public EntityType animal;
	public boolean pedSpawned;
	
	public static List<player_pet> animalList = new ArrayList<player_pet>();
	
	public player_pet(Player _p, EntityType _animal, boolean _pedSpawned) {
		this.p = _p;
		this.animal = _animal;
		this.pedSpawned = _pedSpawned;
	}

}
