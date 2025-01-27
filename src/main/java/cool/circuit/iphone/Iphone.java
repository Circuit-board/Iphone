package cool.circuit.iphone;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class Iphone extends JavaPlugin implements Listener {

    public static ItemStack pane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    public static final Map<Player, Integer> playerMoney = new ConcurrentHashMap<>();
    private static Iphone instance;
    public static FileConfiguration config;

    @Override
    public void onEnable() {
        // Set the plugin instance
        instance = this;
        Bukkit.getLogger().info("Iphone plugin enabled!");

        // Save the default config if it doesn't exist
        this.saveDefaultConfig();
        config = getConfig();

        // Load player balances on plugin enable
        loadPlayerBalances();

        // Register events and commands
        getCommand("iphone").setExecutor(new cool.circuit.iphone.menus.MainGUI());
        Bukkit.getPluginManager().registerEvents(new cool.circuit.iphone.events.InventoryEventHandler(), this);
        Bukkit.getPluginManager().registerEvents(this, this); // Register this class as an event listener
        Bukkit.getPluginManager().registerEvents(new cool.circuit.iphone.events.CraftEventHandler(),this);
        Bukkit.getPluginManager().registerEvents(new cool.circuit.iphone.events.PickupEventHandler(),this);

        // Start the clock updater
        cool.circuit.iphone.menus.ClockGUI.startClockUpdater();

        // Start the scoreboard updater
        //startScoreboardUpdater();
    }

    private void loadPlayerBalances() {
        // Load balances from config when the plugin starts
        if (config.contains("players")) {
            for (String playerUUID : config.getConfigurationSection("players").getKeys(false)) {
                int balance = config.getInt("players." + playerUUID + ".balance", 100);
                Player player = Bukkit.getPlayer(UUID.fromString(playerUUID));
                if (player != null) {
                    playerMoney.put(player, balance);
                }
            }
        }
    }

    @Override
    public void onDisable() {
        // Save all player data when the plugin disables
        for (Player player : Bukkit.getOnlinePlayers()) {
            savePlayerData(player);
        }
        Bukkit.getLogger().info("Iphone plugin disabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerUUID = player.getUniqueId().toString();

        // Check if the player has a balance entry in the config
        if (config.contains("players." + playerUUID)) {
            int balance = config.getInt("players." + playerUUID + ".balance", 100);

            // If balance is 0, reset it to 100
            if (balance == 0) {
                balance = 100;  // Default balance
                config.set("players." + playerUUID + ".balance", balance);  // Update config with the new balance
                saveConfig(); // Save changes to the config file
            }

            // Put the updated balance in the playerMoney map
            playerMoney.put(player, balance);
            player.sendMessage(ChatColor.GREEN + "Welcome back! Your balance is " + balance + ".");
        } else {
            // If player does not exist in the config, set their balance to 100
            int defaultBalance = 100;
            config.set("players." + playerUUID + ".balance", defaultBalance); // Set balance to 100
            saveConfig(); // Save the new balance to the config
            playerMoney.put(player, defaultBalance);
            player.sendMessage(ChatColor.GREEN + "Welcome! Your balance has been set to " + defaultBalance + ".");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // Save the player's balance when they disconnect
        Player player = event.getPlayer();
        savePlayerData(player);
    }

    public void savePlayerData(Player player) {
        // Ensure we are saving the most up-to-date balance
        getLogger().info("Saving data for player: " + player.getUniqueId() + " with balance " + playerMoney.get(player));

        // Save the balance in playerMoney to the config file
        config.set("players." + player.getUniqueId() + ".balance", playerMoney.get(player));
        saveConfig();  // Save the updated config file
    }

    public static int retrievePlayerBalance(Player player) {
        // Return the player's balance or 100 if not found
        return playerMoney.getOrDefault(player, 100);
    }

    public static Iphone getInstance() {
        return instance;
    }
}
