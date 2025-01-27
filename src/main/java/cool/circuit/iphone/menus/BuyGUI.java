package cool.circuit.iphone.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;

import static cool.circuit.iphone.Iphone.pane;
import static cool.circuit.iphone.Iphone.retrievePlayerBalance;

public class BuyGUI {

    public static Inventory createStockMarketBuyInventory(Player player) {
        @Deprecated
        Inventory inv = Bukkit.createInventory(null, 9 * 5, "Stock Market | Buy");

        int balance = retrievePlayerBalance(player);

        player.sendMessage("Welcome to the shop! Your balance is currently: " + balance + ".");

        // Sword category meta item with lore
        ItemStack swordCategory = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordCategoryMeta = swordCategory.getItemMeta();
        swordCategory.setItemMeta(swordCategoryMeta);

        // Tool category
        ItemStack toolCategory = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta toolCategoryMeta = toolCategory.getItemMeta();
        toolCategoryMeta.setDisplayName(ChatColor.AQUA + "Tools");
        toolCategory.setItemMeta(toolCategoryMeta);

        // Armor category
        ItemStack armorCategory = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta armorCategoryMeta = armorCategory.getItemMeta();
        armorCategoryMeta.setDisplayName(ChatColor.AQUA + "Armor Pieces");
        armorCategory.setItemMeta(armorCategoryMeta);

        // Items category
        ItemStack itemCategory = new ItemStack(Material.DIAMOND);
        ItemMeta itemCategoryMeta = itemCategory.getItemMeta();
        itemCategoryMeta.setDisplayName(ChatColor.AQUA + "Items");
        itemCategory.setItemMeta(itemCategoryMeta);

        // Sell switch
        ItemStack sellSwitch = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta sellSwitchMeta = sellSwitch.getItemMeta();
        sellSwitchMeta.setDisplayName(ChatColor.RED + "Sell Items");
        sellSwitch.setItemMeta(sellSwitchMeta);

        // Add yellow panes as decoration

        for (int i = 37; i < 45; i++) {
            inv.setItem(i, pane);
        }

        inv.setItem(0, swordCategory);
        inv.setItem(9, toolCategory);
        inv.setItem(18, armorCategory);
        inv.setItem(27, itemCategory);
        inv.setItem(36, sellSwitch);

        inv.setItem(1,pane);
        inv.setItem(10,pane);
        inv.setItem(19,pane);
        inv.setItem(28,pane);
        inv.setItem(37,pane);

        inv.setItem(8,pane);
        inv.setItem(17,pane);
        inv.setItem(26,pane);
        inv.setItem(35,pane);
        inv.setItem(44,pane);

        // Add actual sword items to the GUI
        int swordSlotStart = 2; // Start placing swords from slot 10
        ItemStack[] swords = {
                createSwordItem(Material.WOODEN_SWORD, "Wooden Sword", 10),
                createSwordItem(Material.STONE_SWORD, "Stone Sword", 20),
                createSwordItem(Material.IRON_SWORD, "Iron Sword", 50),
                createSwordItem(Material.GOLDEN_SWORD, "Golden Sword", 30),
                createSwordItem(Material.DIAMOND_SWORD, "Diamond Sword", 100),
                createSwordItem(Material.NETHERITE_SWORD, "Netherite Sword", 500)
        };

        for (ItemStack sword : swords) {
            inv.setItem(swordSlotStart++, sword); // Place the sword in the inventory
        }

        // Add actual tools items to the GUI
        int toolSlotStart = 11; // Start placing tools after the sword category
        ItemStack[] tools = {
                createToolItem(Material.WOODEN_PICKAXE, "Wooden Tool Kit", 50),
                createToolItem(Material.STONE_PICKAXE, "Stone Tool Kit", 100),
                createToolItem(Material.IRON_PICKAXE, "Iron Tool Kit", 250),
                createToolItem(Material.GOLDEN_PICKAXE, "Golden Tool Kit", 120),
                createToolItem(Material.DIAMOND_PICKAXE, "Diamond Tool Kit", 500),
                createToolItem(Material.NETHERITE_PICKAXE, "Netherite Tool Kit", 1000)
        };

        for (ItemStack tool : tools) {
            inv.setItem(toolSlotStart++, tool); // Place the tool in the inventory
        }

        return inv;
    }

    private static ItemStack createSwordItem(Material material, String name, int price) {
        ItemStack sword = new ItemStack(material);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.GREEN + name);
        sword.setItemMeta(swordMeta);
        return sword;
    }

    public static ItemStack createToolItem(Material material, String name, int price) {
        ItemStack tool = new ItemStack(material);
        ItemMeta toolMeta = tool.getItemMeta();
        toolMeta.setDisplayName(ChatColor.GREEN + name);
        toolMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "Price: " + ChatColor.GOLD + price + " coins",
                ChatColor.GRAY + "Includes: Pickaxe, Shovel, Axe, and Hoe",
                ChatColor.GRAY + "Click to purchase"
        ));
        tool.setItemMeta(toolMeta);
        return tool;
    }
    public static ItemStack createSellToolItem(Material material, String name, int price) {
        ItemStack tool = new ItemStack(material);
        ItemMeta toolMeta = tool.getItemMeta();
        toolMeta.setDisplayName(ChatColor.RED + name);
        toolMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "Price: " + ChatColor.GOLD + price + " coins",
                ChatColor.GRAY + "Includes: Pickaxe, Shovel, Axe, and Hoe",
                ChatColor.GRAY + "Click to sell"
        ));
        tool.setItemMeta(toolMeta);
        return tool;
    }
}
