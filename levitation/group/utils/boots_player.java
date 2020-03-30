package levitation.group.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class boots_player {
	
	public static List<boots_player> bootsPlayers = new ArrayList<boots_player>();
	
	public Player p;
	public Material m;
	public int id;
	
	public boots_player(Player _p, Material _boot, int _id){
		this.p = _p;
		this.m = _boot;
		this.id = _id;
	}

}
