package fr.junkjumper.bingogo;

import java.util.ArrayList;
import java.util.List;


import org.bukkit.Material;

public class BingoItemGenerator {

	public static List<Material> l = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	public static void fillList() {
		for(Material m : Material.values()) {
			if(m.equals(Material.AIR) ||
				m.equals(Material.CAVE_AIR) ||
				m.equals(Material.LAVA) ||
				m.equals(Material.LEGACY_LAVA) ||
				m.equals(Material.LEGACY_STATIONARY_LAVA) ||
				m.equals(Material.WATER) ||
				m.equals(Material.LEGACY_STATIONARY_WATER) ||
				m.equals(Material.LEGACY_WATER) ||
				m.equals(Material.NETHER_PORTAL) ||
				m.equals(Material.BEDROCK) ||
				m.equals(Material.BAT_SPAWN_EGG) ||
				m.equals(Material.BEE_SPAWN_EGG) ||
				m.equals(Material.BLAZE_SPAWN_EGG) ||
				m.equals(Material.CAT_SPAWN_EGG) ||
				m.equals(Material.CAVE_SPIDER_SPAWN_EGG) ||
				m.equals(Material.CHICKEN_SPAWN_EGG) ||
				m.equals(Material.COD_SPAWN_EGG) ||
				m.equals(Material.COW_SPAWN_EGG) ||
				m.equals(Material.CREEPER_SPAWN_EGG) ||
				m.equals(Material.DOLPHIN_SPAWN_EGG) ||
				m.equals(Material.DONKEY_SPAWN_EGG) ||
				m.equals(Material.DROWNED_SPAWN_EGG) ||
				m.equals(Material.ELDER_GUARDIAN_SPAWN_EGG) ||
				m.equals(Material.ENDERMAN_SPAWN_EGG) ||
				m.equals(Material.ENDERMITE_SPAWN_EGG) ||
				m.equals(Material.EVOKER_SPAWN_EGG) ||
				m.equals(Material.FOX_SPAWN_EGG) ||
				m.equals(Material.GHAST_SPAWN_EGG) ||
				m.equals(Material.GUARDIAN_SPAWN_EGG) ||
				m.equals(Material.HOGLIN_SPAWN_EGG) ||
				m.equals(Material.HORSE_SPAWN_EGG) ||
				m.equals(Material.HUSK_SPAWN_EGG) ||
				m.equals(Material.LLAMA_SPAWN_EGG) ||
				m.equals(Material.MAGMA_CUBE_SPAWN_EGG) ||
				m.equals(Material.MOOSHROOM_SPAWN_EGG) ||
				m.equals(Material.MULE_SPAWN_EGG) ||
				m.equals(Material.OCELOT_SPAWN_EGG) ||
				m.equals(Material.PANDA_SPAWN_EGG) ||
				m.equals(Material.PARROT_SPAWN_EGG) ||
				m.equals(Material.PHANTOM_SPAWN_EGG) ||
				m.equals(Material.PIG_SPAWN_EGG) ||
				m.equals(Material.PIGLIN_SPAWN_EGG) ||
				m.equals(Material.PIGLIN_BRUTE_SPAWN_EGG) ||
				m.equals(Material.PILLAGER_SPAWN_EGG) ||
				m.equals(Material.POLAR_BEAR_SPAWN_EGG) ||
				m.equals(Material.PUFFERFISH_SPAWN_EGG) ||
				m.equals(Material.RABBIT_SPAWN_EGG) ||
				m.equals(Material.RAVAGER_SPAWN_EGG) ||
				m.equals(Material.SALMON_SPAWN_EGG) ||
				m.equals(Material.SHEEP_SPAWN_EGG) ||
				m.equals(Material.SHULKER_SPAWN_EGG) ||
				m.equals(Material.SILVERFISH_SPAWN_EGG) ||
				m.equals(Material.SKELETON_SPAWN_EGG) ||
				m.equals(Material.SKELETON_HORSE_SPAWN_EGG) ||
				m.equals(Material.SLIME_SPAWN_EGG) ||
				m.equals(Material.SPIDER_SPAWN_EGG) ||
				m.equals(Material.SQUID_SPAWN_EGG) ||
				m.equals(Material.STRAY_SPAWN_EGG) ||
				m.equals(Material.STRIDER_SPAWN_EGG) ||
				m.equals(Material.TRADER_LLAMA_SPAWN_EGG) ||
				m.equals(Material.TROPICAL_FISH_SPAWN_EGG) ||
				m.equals(Material.TURTLE_SPAWN_EGG) ||
				m.equals(Material.VEX_SPAWN_EGG) ||
				m.equals(Material.VILLAGER_SPAWN_EGG) ||
				m.equals(Material.VINDICATOR_SPAWN_EGG) ||
				m.equals(Material.WANDERING_TRADER_SPAWN_EGG) ||
				m.equals(Material.WITCH_SPAWN_EGG) ||
				m.equals(Material.WITHER_SKELETON_SPAWN_EGG) ||
				m.equals(Material.WOLF_SPAWN_EGG) ||
				m.equals(Material.ZOGLIN_SPAWN_EGG) ||
				m.equals(Material.ZOMBIE_SPAWN_EGG) ||
				m.equals(Material.ZOMBIE_HORSE_SPAWN_EGG) ||
				m.equals(Material.ZOMBIE_VILLAGER_SPAWN_EGG) ||
				m.equals(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG) ||
				m.equals(Material.DRAGON_BREATH)
				) {
					
			} else {
				l.add(m);
			}
		}
	}
	
	public static int getRandomMaterial() {
		return (int) (Math.random()*getL().size());
	}

	public static List<BingoItem> generateItems(int amount) {
		List<BingoItem> bingo = new ArrayList<>();
		fillList();
		for (int i = 0; i < amount; ++i) {
			bingo.add(new BingoItem(l.get(getRandomMaterial())));
		}
		return bingo;
	}

	/**
	 * @return the l
	 */
	private static List<Material> getL() {
		return l;
	}

	
}
