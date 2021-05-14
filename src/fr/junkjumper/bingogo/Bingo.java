package fr.junkjumper.bingogo;

import java.util.List;

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
		}
		
		return sb;
	}
	
	private static String rewriteMarerialName(String m) {
		String s = m.toString().replace("_", " ");
		String ss = s.replaceAll("LEGACY ", "");
		return ss.substring(0, 1) + ss.toLowerCase().substring(1);
	}

	public List<BingoItem> getListe() {
		return liste;
	}

	public boolean isActive() {
		return active;
	}
	

}
