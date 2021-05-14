package fr.junkjumper.bingogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bingo {
	
	private List<BingoItem> liste;
	private boolean active;
	
	public Bingo() {
		 this.active = false;
	}
	
	public void generateBingo(int amount) {
		this.liste = BingoItemGenerator.generateItems(amount);
		this.active = true;
	}
	
	@Override
	public String toString() {
		String sb = "";
		int iterator = 0;
		for(BingoItem b : liste) {
			if(b.getM().isBlock()) {
				if(!b.isGet()) {
					sb += "§a BLOCK Number " + (iterator+1) + " - " + rewriteMarerialName(b.getM().name()) + "\n";
				} else {
					sb += "§m BLOCK Number " + (iterator+1) + " - " + rewriteMarerialName(b.getM().name()) + "\n";
				}
			} else {
				if(!b.isGet()) {
					sb += "§e ITEM Number " + (iterator+1) + " - " + rewriteMarerialName(b.getM().name()) + "\n";
				} else {
					sb += "§m ITEM Number " + (iterator+1) + " - " + rewriteMarerialName(b.getM().name()) + "\n";
				}
			}
			++iterator;
		}
		return sb.substring(0, sb.length()-1);
	}
	
	private static String rewriteMarerialName(String m) {
		String s = m.toString().replace("_", " ");
		String ss = s.replaceAll("LEGACY ", "");
		return ss.substring(0, 1) + ss.toLowerCase().substring(1);
	}

	public String getHelp(String arg) {
		String sb = "";
		switch (arg.toLowerCase()) {
		case "help":
			try {
					File myObj = new File("help/helpMenu.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					sb += data + "\n";
				}
				myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			break;
		case "generate":
			try {
					File myObj = new File("help/helpGenerate.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					sb += data + "\n";
				}
				myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			break;
		case "see":
			try {
					File myObj = new File("help/helpSee.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					sb += data + "\n";
				}
				myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			break;
		case "item":
			try {
					File myObj = new File("help/helpItem.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					sb += data + "\n";
				}
				myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			break;
		case "tpall":
			try {
					File myObj = new File("help/helpTpAll.txt");
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					sb += data + "\n";
				}
				myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			break;
		default:
			break;
		}
		return sb;
	}
	
	
	public List<BingoItem> getListe() {
		return liste;
	}

	public boolean isActive() {
		return active;
	}
	
	public void resetBingo() {
		this.liste = new ArrayList<BingoItem>();
		this.active = false;
	}
	

}
