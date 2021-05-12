package fr.junkjumper.bingogo.commands;

import java.util.List;


import fr.junkjumper.bingogo.BingoItem;
import fr.junkjumper.bingogo.BingoItemGenerator;

public class runa {
	
	public static void main(String[] args) {
		List<BingoItem> liste = BingoItemGenerator.generateItems(9);
		System.out.println(liste);
		
		
	}

}
