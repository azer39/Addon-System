package levitation.group;

import org.bukkit.plugin.java.JavaPlugin;

import levitation.group.commands.cmd_gadgets;
import levitation.group.listeners.event_flightattempt;
import levitation.group.listeners.event_inventoryclick;
import levitation.group.listeners.event_move;

public class main extends JavaPlugin{
	
	public static String prefix = "§eGadgets §8| §7";
	public static main instance;
	
	public void onEnable() {
		instance = this;
		
		registerCommands();
		registerListener();
		
		System.out.println("-=================-");
		System.out.println("   Gadget System   ");
		System.out.println("    made by azer   ");
		System.out.println("     levitation    ");
		System.out.println("-=================-");
	}
	
	private void registerCommands() {
		getCommand("gadgets").setExecutor(new cmd_gadgets());
	}
	
	private void registerListener() {
		getServer().getPluginManager().registerEvents(new event_inventoryclick(), this);
		getServer().getPluginManager().registerEvents(new event_move(), this);
		getServer().getPluginManager().registerEvents(new event_flightattempt(), this);
	}


}
