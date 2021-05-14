package fr.junkjumper.bingogo.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.junkjumper.bingogo.Bingo;
import fr.junkjumper.bingogo.BingoItem;

public class CommandBingo implements CommandExecutor {

	private Bingo bingo = new Bingo(); 


	public String display(List<BingoItem> m) {
		String sb = "";
		String subS = m.toString().substring(1, m.toString().length()-1);
		String[] toWork = subS.split(", ");
		
		for(int i=0; i < toWork.length; ++i) {
			if(m.get(i).getM().isBlock()) {
				if(!m.get(i).isGet()) {
					sb += "§a BLOCK Number " + (i+1) + " - " + toWork[i] + "\n";
				} else {
					sb += "§m BLOCK Number " + (i+1) + " - " + toWork[i] + "\n";
				}
			} else {
				if(!m.get(i).isGet()) {
					sb += "§e ITEM Number " + (i+1) + " - " + toWork[i] + "\n";
				} else {
					sb += "§m ITEM Number " + (i+1) + " - " + toWork[i] + "\n";
				}
			}
		}
		return sb;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		boolean r = false;
		if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("generate")) {
			if(!bingo.isActive()) {
				bingo.generateBingo(Integer.parseInt(args[1]));
				Bukkit.broadcastMessage("§bLe bingo est généré :"); 
				Bukkit.broadcastMessage(bingo.toString());
				r = true;
			} else {
				sender.sendMessage("§4Un bingo est déjà en cours d'utilisation, pour le réinitialisé, faites /bingo reset");
			}
		} else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("see")) {
			sender.sendMessage("§bVous devez trouver :");
					sender.sendMessage(bingo.toString());
			r = true;
		} else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("reset")) {
			sender.sendMessage("§aLe bingo est réinitialisé, tapez /bingo generate pour recommencer une partie"); 
			r = true;
		} else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("item")) {
			if(args[1].equalsIgnoreCase("get")) {
				bingo.getListe().get(Integer.parseInt(args[2])-1).itemPicked();
				Bukkit.broadcastMessage("§5L'objet " + bingo.getListe().get(Integer.parseInt(args[2])-1).getM().toString() + " vient d'être récupéré par " + sender.getName() + ".");
				r = true;
			} else if(args[1].equalsIgnoreCase("unget")) {
				bingo.getListe().get(Integer.parseInt(args[2])-1).itemUnpicked();
				Bukkit.broadcastMessage("§5" + sender.getName() + " vient de retirer l'objet " + bingo.getListe().get(Integer.parseInt(args[2])-1).getM().toString() + " de la liste des objets récupérés. Tapez §f/bingo see §5 pour voir la liste actualisée !");
				r = true;
			} else {
				r = false;
			}
		}
		return r;
	}

}
