package me.franga2000.KickMe;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void OnEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void OnDisable() {
		saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("kickme")) {
				String kickMessage = getConfig().getString("kickMsg");
				player.kickPlayer(kickMessage);
				String kickBroadcast = getConfig().getString("kickBc");
				Bukkit.getServer().broadcastMessage(ChatColor.RED + "[" + ChatColor.YELLOW + "KickMe" + ChatColor.RED + "]" + ChatColor.GREEN + kickBroadcast.replaceAll("$USER$", player.getName()));
			}
		}
	return false;
	}
	
}
