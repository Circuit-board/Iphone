package cool.circuit.iphone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PickupEventHandler implements Listener {

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent event) {
        ItemStack item = event.getItem().getItemStack();

        // Get the item's meta data
        ItemMeta meta = item.getItemMeta();

        // Check if the item has meta data (some items might not have meta)
        if (meta != null) {
            // Set the item as unbreakable
            meta.setUnbreakable(true);

            // Apply the meta data back to the item
            item.setItemMeta(meta);
        }
    }
}
