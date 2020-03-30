package levitation.group.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class entity_location {
	public Entity e;
	public Location loc;
	
	public static List<entity_location> eLocs = new ArrayList<entity_location>();
	
	public entity_location(Entity _e, Location _loc) {
		this.e = _e;
		this.loc = _loc;
	}

}
