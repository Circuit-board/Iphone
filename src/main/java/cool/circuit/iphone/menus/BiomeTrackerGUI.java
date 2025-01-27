package cool.circuit.iphone.menus;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static cool.circuit.iphone.Iphone.pane;

public class BiomeTrackerGUI {

    public static Inventory createBiomeTrackerInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null,9*3,"Biome Tracker");

        World world = player.getWorld();
        Location location = player.getLocation();
        Biome biome = world.getBiome(location);

        ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta grayPaneMeta = grayPane.getItemMeta();
        grayPaneMeta.setDisplayName("§8§kaaaaaaaaa");
        grayPane.setItemMeta(grayPaneMeta);

        ItemStack biomeItem = new ItemStack(Material.DEAD_BUSH);
        ItemMeta biomeItemMeta = biomeItem.getItemMeta();
        biomeItemMeta.setDisplayName("§a§ka§r§a " + biome + " §a§ka");
        biomeItem.setItemMeta(biomeItemMeta);

        for (int i = 0; i < 9 * 3; i++) {
            // Add yellow pane borders
            if (i < 9 || i >= 9 * 2 || i % 9 == 0 || i % 9 == 8) {
                inv.setItem(i, pane); // Set borders to yellow panes
            } else if (i != 13) {
                inv.setItem(i, grayPane); // Set the inner panes to gray
            }
            else {
                inv.setItem(i,biomeItem);
            }
        }

        return inv;
    }

}
