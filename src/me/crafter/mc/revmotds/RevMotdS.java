package me.crafter.mc.revmotds;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RevMotdS extends JavaPlugin {
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public final RevListener pl = new RevListener();
	
	
	
public void onEnable(){
    	PluginDescriptionFile pdfFile = getDescription();
        this.logger.info("PacketTest " + pdfFile.getVersion() + " has been ENABLED!");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.pl, this);
        }
 
public void onDisable() {
    	PluginDescriptionFile pdfFile = getDescription();
        this.logger.info("PacketTest " + pdfFile.getVersion() + " has been DISABLED!");
    	}
	
	
	

}
