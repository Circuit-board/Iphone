package cool.circuit.iphone.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import static cool.circuit.iphone.Iphone.pane;

public class MainGUI implements CommandExecutor, Listener {

    @Override
    @Deprecated
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }
        Player player = (Player) sender;

        OpenMainMenu(player);
        return true;
    }


    public static void OpenMainMenu(Player player) {
        Inventory MainMenu = Bukkit.createInventory(player, 9 * 5, "Iphone");

        player.openInventory(MainMenu);

        ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta grayPaneMeta = grayPane.getItemMeta();
        grayPaneMeta.setDisplayName("§8§kaaaaaaaaa");
        grayPane.setItemMeta(grayPaneMeta);

        ItemStack sunflower = new ItemStack(Material.SUNFLOWER);
        ItemMeta sunflowerMeta = sunflower.getItemMeta();
        sunflowerMeta.setDisplayName("§9§ka §r§9Weather App §9§ka");
        sunflower.setItemMeta(sunflowerMeta);

        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemMeta clockMeta = clock.getItemMeta();
        clockMeta.setDisplayName("§e§ka §r§eClock §e§ka");
        clock.setItemMeta(clockMeta);

        ItemStack stockMarket = new ItemStack(Material.GOLD_INGOT);
        ItemMeta stockMarketMeta = stockMarket.getItemMeta();
        stockMarketMeta.setDisplayName("§6§ka §r§6Stock Market §6§ka");
        stockMarket.setItemMeta(stockMarketMeta);

        ItemStack utils = new ItemStack(Material.BOOK);
        ItemMeta utilsMeta = utils.getItemMeta();
        utilsMeta.setDisplayName("§7§ka §r§7Utility §7§ka");
        utils.setItemMeta(utilsMeta);

        ItemStack biomeTracker = new ItemStack(Material.DEAD_BUSH);
        ItemMeta biomeTrackerMeta = biomeTracker.getItemMeta();
        biomeTrackerMeta.setDisplayName("§a§ka §r§aBiome Tracker §a§ka");
        biomeTracker.setItemMeta(biomeTrackerMeta);

        ItemStack themes = new ItemStack(Material.WHITE_WOOL);
        ItemMeta themesMeta = themes.getItemMeta();
        themesMeta.setDisplayName("§f§ka §rThemes App §f§ka");
        themes.setItemMeta(themesMeta);


        for (int i = 0; i < 9 * 5; i++) {
            // Set the border slots
            if (i < 9 || i >= 9 * 4 || i % 9 == 0 || i % 9 == 8) {
                MainMenu.setItem(i, pane);
            } else if (i == 20) {
                MainMenu.setItem(i, stockMarket); // Middle button
            } else if (i == 21) {
                MainMenu.setItem(i, clock);
            } else if (i == 22) {
                MainMenu.setItem(i, utils);
            } else if (i == 23) {
                MainMenu.setItem(i, sunflower);
            }
            else if (i == 24) {
                MainMenu.setItem(i,biomeTracker);
            } else if (i == 29) {
                MainMenu.setItem(i, themes);
            } else {
                // Set the inside to be empty or any other item
                MainMenu.setItem(i, grayPane);
            }
        }
    }
}