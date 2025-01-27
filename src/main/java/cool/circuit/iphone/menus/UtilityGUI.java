package cool.circuit.iphone.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;

import static cool.circuit.iphone.Iphone.pane;

public class UtilityGUI {

    public static Inventory createUtilityInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null,9*3,"Utility");

        ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta grayPaneMeta = grayPane.getItemMeta();
        grayPaneMeta.setDisplayName("§8§kaaaaaaaaa");
        grayPane.setItemMeta(grayPaneMeta);

        ItemStack yellowPane = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        ItemMeta yellowPaneMeta = yellowPane.getItemMeta();
        yellowPaneMeta.setDisplayName("§e§kaaaaaaaaa");
        yellowPane.setItemMeta(yellowPaneMeta);

        ItemStack enchantingTable = new ItemStack(Material.ENCHANTING_TABLE);
        ItemMeta enchantingTableMeta = enchantingTable.getItemMeta();
        enchantingTableMeta.setDisplayName("§b§ka §r§bEnchanting Table §b§ka");
        enchantingTable.setItemMeta(enchantingTableMeta);

        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilMeta = anvil.getItemMeta();
        anvilMeta.setDisplayName("§7§ka §r§7Anvil §7§ka");
        anvil.setItemMeta(anvilMeta);

        ItemStack furnace = new ItemStack(Material.FURNACE);
        ItemMeta furnaceMeta = furnace.getItemMeta();
        furnaceMeta.setDisplayName("§8§ka §r§8Furnace §8§ka");
        furnace.setItemMeta(furnaceMeta);


        for (int i = 0; i < 9 * 3; i++) {
            // Add yellow pane borders
            if (i < 9 || i >= 9 * 2 || i % 9 == 0 || i % 9 == 8) {
                inv.setItem(i, pane); // Set borders to yellow panes
            } else if (i != 13 && i != 11 && i != 15) {
                inv.setItem(i, grayPane); // Set the inner panes to gray
            } else if (i == 13) {
                inv.setItem(i,enchantingTable);
            } else if (i == 11) {
                inv.setItem(i,furnace);
            } else if (i == 15) {
                inv.setItem(i,anvil);
            }
        }

        return inv;
    }
    public static Inventory createEnchantingInventory() {
        return Bukkit.createInventory(null, InventoryType.ENCHANTING);
    }
    public static Inventory createAnvilInventory() {
        return Bukkit.createInventory(null,InventoryType.ANVIL);
    }
    public static Inventory createFurnaceInventory() {
        Inventory inv = Bukkit.createInventory(null,InventoryType.FURNACE,"Furnace Utility");

        return inv;
    }
}
