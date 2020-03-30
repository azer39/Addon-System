package levitation.group.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.entity.Player;

public class gadget_player {
	
	public static List<Player> iceBoots = new ArrayList<Player>();
	public static List<Player> jumpBoots = new ArrayList<Player>();
	public static List<Player> flyBoots = new ArrayList<Player>();
	
	public static List<gadget_player> players = new ArrayList<gadget_player>();
	
	public Player p;
	public Effect e;

	public gadget_player(Player _p, Effect _e) {
		this.p = _p;
		this.e = _e;
	}
}
