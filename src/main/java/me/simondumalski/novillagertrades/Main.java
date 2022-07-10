package me.simondumalski.novillagertrades;

import me.simondumalski.novillagertrades.commands.NoVillagerTradesCommand;
import me.simondumalski.novillagertrades.listeners.VillagerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        //Load the config.yml
        saveDefaultConfig();
        reloadConfig();

        //Register the event listeners
        getServer().getPluginManager().registerEvents(new VillagerInteractListener(this), this);

        //Set the command executors
        getCommand("novillagertrades").setExecutor(new NoVillagerTradesCommand(this));

    }

}
