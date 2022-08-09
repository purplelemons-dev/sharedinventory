package group.thebasement.plugins.shareinv.handlers;

import group.thebasement.plugins.shareinv.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class PlayerHandler implements Listener {
    private final Main plugin;
    public PlayerHandler(Main plugin) {
        this.plugin=plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void delay(Runnable task, long pause) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, task, pause);
    }

    public void updateAllInventories(Player player, long pause) {
        this.delay(() -> {
            for (Player onlinePlayer: plugin.getServer().getOnlinePlayers()) {
                if (player.equals(onlinePlayer)) continue;
                onlinePlayer.getInventory().setArmorContents(player.getInventory().getArmorContents());
                onlinePlayer.getInventory().setContents(player.getInventory().getContents());
            }
        }, pause);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        this.updateAllInventories(e.getPlayer(), 2);
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        this.updateAllInventories(e.getPlayer(), 2);
    }
    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent e) {
        this.updateAllInventories(e.getPlayer(), 2);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        this.updateAllInventories(e.getPlayer(), 2);
    }
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        this.updateAllInventories((Player) e.getWhoClicked(), 2);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        this.updateAllInventories((Player) e.getWhoClicked(), 2);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        for (Player onlinePlayer: Bukkit.getOnlinePlayers()) {
            if (!(onlinePlayer.equals(e.getEntity()))) {
                this.updateAllInventories(onlinePlayer,2);
                return;
            }
        }

    }

}
