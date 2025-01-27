package cool.circuit.iphone.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static cool.circuit.iphone.Iphone.pane;

public class WeatherAppGUI {
    public static Inventory createWeatherAppInventory(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "Weather App");
        World world = player.getWorld();
        boolean isRaining = world.hasStorm();
        boolean isThundering = world.isThundering();
        String weather = "§e§l§ka §r§e§lIt's clear! §e§l§ka";
        if (isRaining) {
            if (!isThundering) {
                weather = "§9§l§ka §r§9§lIt's raining! §9§l§ka";
            } else {
                weather = "§1§l§ka §r§1§lIt's raining with thunder! §1§l§ka";
            }
        }

        ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta grayPaneMeta = grayPane.getItemMeta();
        grayPaneMeta.setDisplayName("§8§kaaaaaaaaa");
        grayPane.setItemMeta(grayPaneMeta);

        ItemStack weatherItem = new ItemStack(Material.SUNFLOWER);
        ItemMeta weatherItemMeta = weatherItem.getItemMeta();
        weatherItemMeta.setDisplayName(weather);
        weatherItem.setItemMeta(weatherItemMeta);

        for(int i = 0; i < 27; ++i) {
            if (i >= 9 && i < 18 && i % 9 != 0 && i % 9 != 8) {
                if (i != 13) {
                    inv.setItem(i, grayPane);
                } else {
                    inv.setItem(i, weatherItem);
                }
            } else {
                inv.setItem(i, pane);
            }
        }

        return inv;
    }
}
