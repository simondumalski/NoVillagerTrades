package me.simondumalski.novillagertrades;

import me.simondumalski.novillagertrades.listeners.VillagerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        //Register the event listener for interacting with Villagers
        getServer().getPluginManager().registerEvents(new VillagerInteractListener(), this);

    }

}
