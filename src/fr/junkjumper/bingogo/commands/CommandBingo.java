package fr.junkjumper.bingogo.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.junkjumper.bingogo.BingoItemGenerator;

public class CommandBingo implements CommandExecutor {

	public static List<Material> liste = new ArrayList<>();
	private boolean active = false;
	
	public String display(String s, List<Material> m) {
		String sb = "";
		String[] toWork = s.split(", ");
		
		for(int i=0; i < toWork.length; ++i) {
			if(m.get(i).isBlock()) {
				sb += "§a BLOCK - " + toWork[i] + "\n";
			} else {
				sb += "§e BLOCK - " + toWork[i] + "\n";
			}
		}
		return sb;
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("generate")) {
			if(!active) {
				liste = BingoItemGenerator.generate9items();
				Bukkit.broadcastMessage("§bLe bingo est généré :"); active = true;
				
				Bukkit.broadcastMessage(display(liste.toString(), liste));
				return true;
			} else {
				sender.sendMessage("§4Un bingo est déjà en cours d'utilisation, pour le réinitialisé, faites /bingo reset");
			}
		} else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("see")) {
			sender.sendMessage("§bVous devez trouver :");
					sender.sendMessage(display(liste.toString(), liste));
			return true;
		} else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("reset")) {
			sender.sendMessage("§aLe bingo est réinitialisé, tapez /bingo generate pour recommencer une partie"); active = false;
			return true;
		}
		return false;
	}

}
