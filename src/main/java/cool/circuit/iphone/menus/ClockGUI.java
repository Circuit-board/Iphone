package cool.circuit.iphone.menus;

import cool.circuit.iphone.Iphone;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

import static cool.circuit.iphone.Iphone.pane;

public class ClockGUI {
    public static final Map<Player, Inventory> openClocks = new HashMap<>();

    public static void startClockUpdater() {
        Bukkit.getScheduler().runTaskTimer(Iphone.getInstance(), () -> {
            for (Map.Entry<Player, Inventory> entry : openClocks.entrySet()) {
                Player player = entry.getKey();
                Inventory inventory = entry.getValue();
                updateClockItem(inventory, player.getWorld());
                player.updateInventory(); // Ensure the inventory visually updates
            }
        }, 0L, 20L); // Run every 20 ticks (1 second)
    }

    public static void updateClockItem(Inventory inv, World world) {
        long timeInHoursScaled = world.getTime();

        int hours = (int) (timeInHoursScaled / 1000);
        int minutes = (int) ((timeInHoursScaled % 1000) * 60 / 1000);
        int seconds = (int) ((timeInHoursScaled % 1000) * 3600 / 1000) % 60;

        String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        ItemStack clock = new ItemStack(Material.CLOCK);
        ItemMeta clockMeta = clock.getItemMeta();
        clockMeta.setDisplayName("§e§ka§r§e" + formattedTime + "§e§ka");
        clock.setItemMeta(clockMeta);

        inv.setItem(13, clock);
    }


    public static Inventory createClockInventory(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9 * 3, "Clock");

        ItemStack grayPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta grayPaneMeta = grayPane.getItemMeta();
        grayPaneMeta.setDisplayName("§8§kaaaaaaaaa");
        grayPane.setItemMeta(grayPaneMeta);

        for (int i = 0; i < 9 * 3; i++) {
            // Add yellow pane borders
            if (i < 9 || i >= 9 * 2 || i % 9 == 0 || i % 9 == 8) {
                inv.setItem(i, pane); // Set borders to yellow panes
            } else if (i != 13 && i != 22) {
                inv.setItem(i, grayPane); // Set the inner panes to gray
            }
        }

        updateClockItem(inv, player.getWorld()); // Set the initial clock item
        return inv;
    }
}
