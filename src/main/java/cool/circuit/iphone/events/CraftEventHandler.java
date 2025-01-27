package cool.circuit.iphone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftEventHandler implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        // Get the resulting crafted item
        ItemStack result = event.getCurrentItem();

        // Check if the result item is not null
        if (result != null) {
            // Get the item's meta data
            ItemMeta meta = result.getItemMeta();

            // Check if the item has meta data (some items might not have meta)
            if (meta != null) {
                // Set the item as unbreakable
                meta.setUnbreakable(true);

                // Apply the meta data back to the item
                result.setItemMeta(meta);
            }
        }
    }
}
