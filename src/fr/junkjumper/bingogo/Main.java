package fr.junkjumper.bingogo;

import org.bukkit.plugin.java.JavaPlugin;

import fr.junkjumper.bingogo.commands.CommandBingo;


public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Plugin Bingo Activé !");
		getCommand("bingo").setExecutor(new CommandBingo());
	}
	
	@Override
	public void onDisable() {
		System.out.println("Plugin Bingo Désactivé !");
	}

	
}
