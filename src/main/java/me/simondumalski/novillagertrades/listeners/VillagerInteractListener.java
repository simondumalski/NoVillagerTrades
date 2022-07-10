package me.simondumalski.novillagertrades.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerInteractListener implements Listener {

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
            //Send the player a message
            player.sendMessage(ChatColor.RED + "You have bypassed the villager trading blocker!");
            return;
        }

        //Cancel the villager interact event
        e.setCancelled(true);

        //Send the player a message
        player.sendMessage(ChatColor.RED + "Villager trading is currently disabled!");

    }

}
