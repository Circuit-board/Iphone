package cool.circuit.iphone.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static cool.circuit.iphone.menus.BiomeTrackerGUI.createBiomeTrackerInventory;
import static cool.circuit.iphone.menus.ClockGUI.*;
import static cool.circuit.iphone.Iphone.playerMoney;
import static cool.circuit.iphone.Iphone.retrievePlayerBalance;
import static cool.circuit.iphone.menus.BuyGUI.createStockMarketBuyInventory;
import static cool.circuit.iphone.menus.SellGUI.createStockMarketSellInventory;
import static cool.circuit.iphone.menus.UtilityGUI.*;
import static cool.circuit.iphone.menus.WeatherAppGUI.createWeatherAppInventory;

public class InventoryEventHandler implements Listener {


    private static final int[] BUTTON_SLOTS_FOR_45 = {20,21,22,23,24,29};

    // Create the click button with the current score




    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Ensure the click is from a player
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();
        String title = event.getView().getTitle();
        int slot = event.getSlot();

        // Only handle custom GUIs
        if ((!title.equals("Iphone")
                && !title.equals("Clicker Game")
                && !title.equals("Weather App")
                && !title.equals("Clock")
                && !title.equals("Biome Tracker")
                && !title.equals("Stock Market | Buy")
                && !title.equals("Stock Market | Sell")
                && !title.equals("Utility")
                && !title.equals("Themes")
                /*&& (!title.equals("Furnace Utility") && slot == 1)*/)) {
            return;
        }

        event.setCancelled(true); // Prevent item movement

        if(title.equals("Stock Market | Buy") && slot == 36) {
            player.openInventory(createStockMarketSellInventory(player));
        }
        if(title.equals("Stock Market | Sell") && slot == 36) {
            player.openInventory(createStockMarketBuyInventory(player));
        }
        if(title.equals("Utility") && slot == 13) {
            player.openInventory(createEnchantingInventory());
        } else if (title.equals("Utility") && slot == 15) {
            player.openInventory(createAnvilInventory());
        } else if (title.equals("Utility") && slot == 11) {
            player.openInventory(createFurnaceInventory());
        }

        int balance = retrievePlayerBalance(player);

        if (title.equals("Stock Market | Buy")) {
            switch (slot) {
                case 2: {
                    if (balance >= 10) {
                        balance -= 10;
                        ItemStack woodenSword = new ItemStack(Material.WOODEN_SWORD);
                        ItemMeta meta = woodenSword.getItemMeta();
                        meta.setUnbreakable(true); // Set the item as unbreakable
                        woodenSword.setItemMeta(meta);
                        player.getInventory().addItem(woodenSword);
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Purchase of wooden sword successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 3: {
                    if (balance >= 20) {
                        balance -= 20;
                        ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
                        ItemMeta meta = stoneSword.getItemMeta();
                        meta.setUnbreakable(true); // Set the item as unbreakable
                        stoneSword.setItemMeta(meta);
                        player.getInventory().addItem(stoneSword);
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Purchase of stone sword successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 4: {
                    if (balance >= 50) {
                        balance -= 50;
                        ItemStack ironSword = new ItemStack(Material.IRON_SWORD);
                        ItemMeta meta = ironSword.getItemMeta();
                        meta.setUnbreakable(true); // Set the item as unbreakable
                        ironSword.setItemMeta(meta);
                        player.getInventory().addItem(ironSword);
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Purchase of iron sword successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 5: {
                    if (balance >= 30) {
                        balance -= 30;
                        ItemStack goldenSword = new ItemStack(Material.GOLDEN_SWORD);
                        ItemMeta meta = goldenSword.getItemMeta();
                        meta.setUnbreakable(true); // Set the item as unbreakable
                        goldenSword.setItemMeta(meta);
                        player.getInventory().addItem(goldenSword);
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Purchase of golden sword successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 6: {
                    if (balance >= 100) {
                        balance -= 100;
                        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
                        ItemMeta meta = diamondSword.getItemMeta();
                        meta.setUnbreakable(true); // Set the item as unbreakable
                        diamondSword.setItemMeta(meta);
                        player.getInventory().addItem(diamondSword);
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Purchase of diamond sword successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 7: {
                    if (balance >= 500) {
                        balance -= 500;
                        ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD);
                        ItemMeta meta = netheriteSword.getItemMeta();
                        meta.setUnbreakable(true); // Set the item as unbreakable
                        netheriteSword.setItemMeta(meta);
                        player.getInventory().addItem(netheriteSword);
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Purchase of netherite sword successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 11: { // Toolkit Level 1
                    if (balance >= 50) {
                        balance -= 50;
                        ItemStack axe = new ItemStack(Material.WOODEN_AXE);
                        ItemMeta axeMeta = axe.getItemMeta();
                        axeMeta.setUnbreakable(true);
                        axe.setItemMeta(axeMeta);

                        ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
                        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                        pickaxeMeta.setUnbreakable(true);
                        pickaxe.setItemMeta(pickaxeMeta);

                        player.getInventory().addItem(axe, pickaxe);
                        playerMoney.put(player, balance);
                        player.sendMessage("Purchase of Toolkit Level 1 successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 12: { // Toolkit Level 2
                    if (balance >= 100) {
                        balance -= 100;
                        ItemStack axe = new ItemStack(Material.STONE_AXE);
                        ItemMeta axeMeta = axe.getItemMeta();
                        axeMeta.setUnbreakable(true);
                        axe.setItemMeta(axeMeta);

                        ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE);
                        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                        pickaxeMeta.setUnbreakable(true);
                        pickaxe.setItemMeta(pickaxeMeta);

                        player.getInventory().addItem(axe, pickaxe);
                        playerMoney.put(player, balance);
                        player.sendMessage("Purchase of Toolkit Level 2 successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 13: { // Toolkit Level 3
                    if (balance >= 250) {
                        balance -= 250;
                        ItemStack axe = new ItemStack(Material.IRON_AXE);
                        ItemMeta axeMeta = axe.getItemMeta();
                        axeMeta.setUnbreakable(true);
                        axe.setItemMeta(axeMeta);

                        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
                        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                        pickaxeMeta.setUnbreakable(true);
                        pickaxe.setItemMeta(pickaxeMeta);

                        player.getInventory().addItem(axe, pickaxe);
                        playerMoney.put(player, balance);
                        player.sendMessage("Purchase of Toolkit Level 3 successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 14: { // Toolkit Level 4
                    if (balance >= 120) {
                        balance -= 120;
                        ItemStack axe = new ItemStack(Material.GOLDEN_AXE);
                        ItemMeta axeMeta = axe.getItemMeta();
                        axeMeta.setUnbreakable(true);
                        axe.setItemMeta(axeMeta);

                        ItemStack pickaxe = new ItemStack(Material.GOLDEN_PICKAXE);
                        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                        pickaxeMeta.setUnbreakable(true);
                        pickaxe.setItemMeta(pickaxeMeta);

                        player.getInventory().addItem(axe, pickaxe);
                        playerMoney.put(player, balance);
                        player.sendMessage("Purchase of Toolkit Level 4 successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 15: { // Toolkit Level 5
                    if (balance >= 500) {
                        balance -= 500;
                        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
                        ItemMeta axeMeta = axe.getItemMeta();
                        axeMeta.setUnbreakable(true);
                        axe.setItemMeta(axeMeta);

                        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
                        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                        pickaxeMeta.setUnbreakable(true);
                        pickaxe.setItemMeta(pickaxeMeta);

                        player.getInventory().addItem(axe, pickaxe);
                        playerMoney.put(player, balance);
                        player.sendMessage("Purchase of Toolkit Level 5 successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 16: { // Toolkit Level 6
                    if (balance >= 1000) { // Higher cost for Netherite
                        balance -= 1000;
                        ItemStack axe = new ItemStack(Material.NETHERITE_AXE);
                        ItemMeta axeMeta = axe.getItemMeta();
                        axeMeta.setUnbreakable(true);
                        axe.setItemMeta(axeMeta);

                        ItemStack pickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
                        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                        pickaxeMeta.setUnbreakable(true);
                        pickaxe.setItemMeta(pickaxeMeta);

                        player.getInventory().addItem(axe, pickaxe);
                        playerMoney.put(player, balance);
                        player.sendMessage("Purchase of Toolkit Level 6 successful! Your balance is now: " + balance + "!");
                    }
                    return;
                }
                case 17: { // Placeholder or future extension
                    player.sendMessage("This slot is reserved for future items!");
                    return;
                }
            }
        return;
    }





        if (title.equals("Stock Market | Sell")) {
            switch (slot) {
                case 2: // Selling Wooden Sword
                    if (hasItem(player, Material.WOODEN_SWORD)) {
                        balance += 5; // Example sell price for wooden sword
                        removeItem(player, Material.WOODEN_SWORD); // Remove 1 wooden sword
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Sale of wooden sword successful! Your balance is now: " + balance + "!");
                    } else {
                        player.sendMessage("You do not have a wooden sword to sell.");
                    }
                    return;
                case 3: // Selling Stone Sword
                    if (hasItem(player, Material.STONE_SWORD)) {
                        balance += 10; // Example sell price for stone sword
                        removeItem(player, Material.STONE_SWORD); // Remove 1 stone sword
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Sale of stone sword successful! Your balance is now: " + balance + "!");
                    } else {
                        player.sendMessage("You do not have a stone sword to sell.");
                    }
                    return;
                case 4: // Selling Iron Sword
                    if (hasItem(player, Material.IRON_SWORD)) {
                        balance += 25; // Example sell price for iron sword
                        removeItem(player, Material.IRON_SWORD); // Remove 1 iron sword
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Sale of iron sword successful! Your balance is now: " + balance + "!");
                    } else {
                        player.sendMessage("You do not have an iron sword to sell.");
                    }
                    return;
                case 5: // Selling Golden Sword
                    if (hasItem(player, Material.GOLDEN_SWORD)) {
                        balance += 15; // Example sell price for gold sword
                        removeItem(player, Material.GOLDEN_SWORD); // Remove 1 gold sword
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Sale of golden sword successful! Your balance is now: " + balance + "!");
                    } else {
                        player.sendMessage("You do not have a golden sword to sell.");
                    }
                    return;
                case 6: // Selling Diamond Sword
                    if (hasItem(player, Material.DIAMOND_SWORD)) {
                        balance += 50; // Example sell price for diamond sword
                        removeItem(player, Material.DIAMOND_SWORD); // Remove 1 diamond sword
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Sale of diamond sword successful! Your balance is now: " + balance + "!");
                    } else {
                        player.sendMessage("You do not have a diamond sword to sell.");
                    }
                    return;
                case 7: // Selling Netherite Sword
                    if (hasItem(player, Material.NETHERITE_SWORD)) {
                        balance += 200; // Example sell price for netherite sword
                        removeItem(player, Material.NETHERITE_SWORD); // Remove 1 netherite sword
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Sale of netherite sword successful! Your balance is now: " + balance + "!");
                    } else {
                        player.sendMessage("You do not have a netherite sword to sell.");
                    }
                    return;
                case 11: // Kit 1 (Wooden tools)
                    if (hasItem(player, Material.WOODEN_AXE) && hasItem(player, Material.WOODEN_PICKAXE)) {
                        removeItem(player, Material.WOODEN_AXE);
                        removeItem(player, Material.WOODEN_PICKAXE);
                        balance += 25; // Example price for kit 1
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Kit 1 sold! Your balance is now: " + balance + "!");
                        return;
                    }// Example price for kit 1
                    player.sendMessage("Kit 1 sold! Your balance is now: " + balance + "!");
                    return;

                case 12: // Kit 2 (Stone tools)
                    if (hasItem(player, Material.STONE_AXE) && hasItem(player, Material.STONE_PICKAXE)) {
                        removeItem(player, Material.STONE_AXE);
                        removeItem(player, Material.STONE_PICKAXE);
                        balance += 50; // Example price for kit 2
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Kit 2 sold! Your balance is now: " + balance + "!");
                        return;
                    }// Example price for kit 2
                    player.sendMessage("Kit 2 sold! Your balance is now: " + balance + "!");
                    return;

                case 13: // Kit 3 (Iron tools)
                    if (hasItem(player, Material.IRON_AXE) && hasItem(player, Material.IRON_PICKAXE)) {
                        removeItem(player, Material.IRON_AXE);
                        removeItem(player, Material.IRON_PICKAXE);
                        balance += 125; // Example price for kit 3
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Kit 3 sold! Your balance is now: " + balance + "!");
                        return;
                    }// Example price for kit 3
                    player.sendMessage("Kit 3 sold! Your balance is now: " + balance + "!");
                    return;

                case 14: // Kit 4 (Gold tools)
                    if (hasItem(player, Material.GOLDEN_AXE) && hasItem(player, Material.GOLDEN_PICKAXE)) {
                        removeItem(player, Material.GOLDEN_AXE);
                        removeItem(player, Material.GOLDEN_PICKAXE);
                        balance += 60; // Example price for kit 4
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Kit 4 sold! Your balance is now: " + balance + "!");
                        return;
                    }// Example price for kit 4
                    player.sendMessage("Kit 4 sold! Your balance is now: " + balance + "!");
                    return;

                case 15: // Kit 5 (Diamond tools)
                    if (hasItem(player, Material.DIAMOND_AXE) && hasItem(player, Material.DIAMOND_PICKAXE)) {
                        removeItem(player, Material.DIAMOND_AXE);
                        removeItem(player, Material.DIAMOND_PICKAXE);
                        balance += 250; // Example price for kit 5
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Kit 5 sold! Your balance is now: " + balance + "!");
                        return;
                    }// Example price for kit 5
                    player.sendMessage("Kit 5 sold! Your balance is now: " + balance + "!");
                    return;

                case 16: // Kit 6 (Netherite tools)
                    if (hasItem(player, Material.NETHERITE_AXE) && hasItem(player, Material.NETHERITE_PICKAXE)) {
                        removeItem(player, Material.NETHERITE_AXE);
                        removeItem(player, Material.NETHERITE_PICKAXE);
                        balance += 500; // Example price for kit 6
                        playerMoney.put(player, balance); // Update the player's balance
                        player.sendMessage("Kit 6 sold! Your balance is now: " + balance + "!");
                        return;
                    }
                    player.sendMessage("Kit 6 sold! Your balance is now: " + balance + "!");
                    return;


            }
        }



        // Handle "Iphone" inventory
        if (title.equals("Iphone") && slot == BUTTON_SLOTS_FOR_45[0]) {
            player.openInventory(createStockMarketBuyInventory(player));
            return;
        }
        if (title.equals("Iphone") && slot == BUTTON_SLOTS_FOR_45[1]) {
            Inventory clockInventory = createClockInventory(player);
            openClocks.put(player, clockInventory); // Add to map
            player.openInventory(clockInventory);
        }

        if (title.equals("Iphone") && slot == BUTTON_SLOTS_FOR_45[2]) {
            player.openInventory(createUtilityInventory(player));
        }

        // Handle the button for opening the weather app inventory
        if (title.equals("Iphone") && slot == BUTTON_SLOTS_FOR_45[3]) {
            player.openInventory(createWeatherAppInventory(player));
        }
        if(title.equals("Iphone") && slot == BUTTON_SLOTS_FOR_45[4]) {
            player.openInventory(createBiomeTrackerInventory(player));
        }


        if (title.equals("Weather App") || title.equals("Clock") ||
                title.equals("Biome Tracker") || title.equals("Stock Market | Buy") ||
                title.equals("Stock Market | Sell") ||
                title.equals("Utility")) {
            return;
        }
        //player.sendMessage(String.valueOf(event.getSlot()));

    }

    private void removeItem(Player player, Material material) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() == material && item.getItemMeta().isUnbreakable()) {
                item.setAmount(item.getAmount() - 1);
                if (item.getAmount() <= 0) {
                    player.getInventory().remove(item);
                }
                break;
            }
        }
    }

    private boolean hasItem(Player player, Material material) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() == material && item.getItemMeta().isUnbreakable()) {
                return true;
            }
        }
        return false;
    }
}
