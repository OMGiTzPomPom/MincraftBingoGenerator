package fr.junkjumper.bingogo.commands;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.junkjumper.bingogo.Bingo;

public class CommandBingo implements CommandExecutor {

	private Bingo bingo = new Bingo(); 

	private static int getArgc(Command cmd) {
		return cmd.toString().split(" ").length;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		boolean r = false;
		
		/***********************
		 * /bingo generate {n} *
		 ***********************/
		if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("generate")) {
			if(!bingo.isActive()) {
				if(getArgc(cmd) == 2) {
					bingo.generateBingo(9);
				} else {
					bingo.generateBingo(Integer.parseInt(args[1]));
				}
				Bukkit.broadcastMessage("§bLe bingo est généré :"); 
				Bukkit.broadcastMessage(bingo.toString());
				r = true;
			} else {
				sender.sendMessage("§4Un bingo est déjà en cours d'utilisation, pour le réinitialisé, faites /bingo reset");
				r = true;
			}
		}
		
		/**************
		 * /bingo see *
		 **************/
		else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("see") && getArgc(cmd) == 2) {
			sender.sendMessage("§bVous devez trouver :");
					sender.sendMessage(bingo.toString());
			r = true;
		}
		
		/****************
		 * /bingo reset *
		 ****************/
		else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("reset") && getArgc(cmd) == 2) {
			if(bingo.isActive()) {
				sender.sendMessage("§aLe bingo est réinitialisé, tapez /bingo generate pour recommencer une partie");
				bingo.resetBingo();	
			}
			r = true;
		}
		
		/*****************************
		 * /bingo item [get | unget] id *
		 *****************************/
		else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("item") && getArgc(cmd) == 4) {
			if(args[1].equalsIgnoreCase("get")) {
				bingo.getListe().get(Integer.parseInt(args[2])-1).itemPicked();
				Bukkit.broadcastMessage("§5L'objet " + bingo.getListe().get(Integer.parseInt(args[2])-1).getM().toString() + " vient d'être récupéré par " + sender.getName() + ".");
				r = true;
			} else if(args[1].equalsIgnoreCase("unget")) {
				bingo.getListe().get(Integer.parseInt(args[2])-1).itemUnpicked();
				Bukkit.broadcastMessage("§5" + sender.getName() + " vient de retirer l'objet " + bingo.getListe().get(Integer.parseInt(args[2])-1).getM().toString() + " de la liste des objets récupérés. Tapez §f/bingo see §5 pour voir la liste actualisée !");
				r = true;
			}
			else {
				r = false;
			}
		}
		
		/****************************
		 * /bingo tpall {worldName} *
		 ****************************/
		else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("tpall")) {
			int tmpI = 1;
			if(getArgc(cmd) == 2) {
				for(Player p : Bukkit.getOnlinePlayers()) {
					Bukkit.broadcastMessage("§5Téléportation de " + p.getName() + " vers le monde de la partie en cours (" + tmpI + "/)" + Bukkit.getOnlinePlayers().size() + ")");
					Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "mvtp " + p.getName() + " game");
					try {
						TimeUnit.MILLISECONDS.sleep(200);
						++tmpI;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for(Player p : Bukkit.getOnlinePlayers()) {
					Bukkit.broadcastMessage("§5Téléportation de " + p.getName() + " vers le monde de la partie en cours (" + tmpI + "/)" + Bukkit.getOnlinePlayers().size() + ")");
					Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "mvtp " + p.getName() + " " + args[1]);
					try {
						TimeUnit.MILLISECONDS.sleep(200);
						++tmpI;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			r = true;
		}
		
		/***************
		 * /bingo help *
		 ***************/
		else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("help") && getArgc(cmd) == 2) {
			sender.sendMessage(bingo.getHelp("help"));
			r = true;
		}
		
		/**************************
		 * /bingo help {helpPage} *
		 **************************/
		else if(cmd.getName().equalsIgnoreCase("bingo") && args[0].equalsIgnoreCase("help") && getArgc(cmd) == 3) {
			sender.sendMessage(bingo.getHelp(args[1]));
			r = true;
		}
		
		return r;
	}
}
