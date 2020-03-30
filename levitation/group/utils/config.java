package levitation.group.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class config {
	
	private static FileConfiguration cfg;
	private static File file;
	
	public static void initConfig() {
		file = new File("plugins/Gadgets", "config.yml");
		cfg = YamlConfiguration.loadConfiguration(file);
		cfg.options().copyDefaults(true);
		cfg.options().header("Gadgets Config");
		cfg.addDefault("config.enabled", true);
		saveConfig();
	}
	
	public static void saveConfig() {
		try {
			cfg.save(file);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static FileConfiguration getCfg() {
		return cfg;
	}

}
