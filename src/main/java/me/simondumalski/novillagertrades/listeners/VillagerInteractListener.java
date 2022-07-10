package me.simondumalski.novillagertrades.listeners;

import me.simondumalski.novillagertrades.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerInteractListener implements Listener {

    private final Main plugin;

    public VillagerInteractListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onVillagerTrade(PlayerInteractEntityEvent e) {

        //Get the entity being interacted with
        Entity entity = e.getRightClicked();

        //Check if the entity is a villager
        if (!(entity instanceof Villager)) {
            return;
        }

        //Get the player who is interacting with the villager
        Player player = e.getPlayer();

        //Check if the player can bypass the trading blocker
        if (player.hasPermission("novillagertrades.bypass")) {

            //Get the bypass message from the config.yml
            String message = plugin.getConfig().getString("messages.bypass");

            //Check if the message is valid
            if (message == null) {
                message = "messages.bypass";
            }

            //Send the message to the player
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
            return;
        }

        //Cancel the interact event
        e.setCancelled(true);

        //Get the no-trade message from the config.yml
        String message = plugin.getConfig().getString("messages.no-trade");

        //Check if the message is valid
        if (message == null) {
            message = "messages.no-trade";
        }

        //Send the message to the player
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

    }

}
