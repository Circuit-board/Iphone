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
import static cool.circuit.iphone.menus.BuyGUI.createSellToolItem;

public class SellGUI {
    public static Inventory createStockMarketSellInventory(Player player) {
        @Deprecated
        Inventory inv = Bukkit.createInventory(null, 9 * 5, "Stock Market | Sell");

        int balance = retrievePlayerBalance(player);

        player.sendMessage("Welcome to the shop! Your balance is currently: " + balance + ".");

        // Sword category meta item with lore
        ItemStack swordCategory = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordCategoryMeta = swordCategory.getItemMeta();
        swordCategoryMeta.setDisplayName(ChatColor.AQUA + "Swords");
        swordCategoryMeta.setLore(
                Arrays.asList(
                        ChatColor.GRAY + "Available Swords to Sell:",
                        ChatColor.WHITE + "- Wooden Sword",
                        ChatColor.WHITE + "- Stone Sword",
                        ChatColor.WHITE + "- Iron Sword",
                        ChatColor.WHITE + "- Golden Sword",
                        ChatColor.WHITE + "- Diamond Sword",
                        ChatColor.WHITE + "- Netherite Sword"
                )
        );
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

        // Buy switch
        ItemStack buySwitch = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta buySwitchMeta = buySwitch.getItemMeta();
        buySwitchMeta.setDisplayName(ChatColor.GREEN + "Buy Items");
        buySwitch.setItemMeta(buySwitchMeta);

        for (int i = 37; i < 45; i++) {
            inv.setItem(i, pane);
        }

        inv.setItem(0, swordCategory);
        inv.setItem(9, toolCategory);
        inv.setItem(18, armorCategory);
        inv.setItem(27, itemCategory);
        inv.setItem(36, buySwitch);

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
        // Add actual sword items with prices and lore to the GUI
        int swordSlotStart = 2; // Start placing swords from slot 10
        ItemStack[] swords = {
                createSwordItem(Material.WOODEN_SWORD, "Wooden Sword", 5),
                createSwordItem(Material.STONE_SWORD, "Stone Sword", 10),
                createSwordItem(Material.IRON_SWORD, "Iron Sword", 25),
                createSwordItem(Material.GOLDEN_SWORD, "Golden Sword", 15),
                createSwordItem(Material.DIAMOND_SWORD, "Diamond Sword", 50),
                createSwordItem(Material.NETHERITE_SWORD, "Netherite Sword", 250)
        };

        for (ItemStack sword : swords) {
            inv.setItem(swordSlotStart++, sword); // Place the sword in the inventory
        }

        int toolSlotStart = 11; // Start placing tools after the sword category
        ItemStack[] tools = {
                createSellToolItem(Material.WOODEN_PICKAXE, "Wooden Tool Kit", 25),
                createSellToolItem(Material.STONE_PICKAXE, "Stone Tool Kit", 50),
                createSellToolItem(Material.IRON_PICKAXE, "Iron Tool Kit", 125),
                createSellToolItem(Material.GOLDEN_PICKAXE, "Golden Tool Kit", 60),
                createSellToolItem(Material.DIAMOND_PICKAXE, "Diamond Tool Kit", 250),
                createSellToolItem(Material.NETHERITE_PICKAXE, "Netherite Tool Kit", 500)
        };

        for (ItemStack tool : tools) {
            inv.setItem(toolSlotStart++, tool); // Place the tool in the inventory
        }

        return inv;
    }

    private static ItemStack createSwordItem(Material material, String name, int price) {
        ItemStack sword = new ItemStack(material);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.RED + name);
        swordMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "Price: " + ChatColor.GOLD + price + " coins",
                ChatColor.GRAY + "Click to sell"
        ));
        sword.setItemMeta(swordMeta);
        return sword;
    }
}
