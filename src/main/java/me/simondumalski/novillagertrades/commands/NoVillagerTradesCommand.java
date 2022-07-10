package me.simondumalski.novillagertrades.commands;

import me.simondumalski.novillagertrades.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class NoVillagerTradesCommand implements CommandExecutor {

    private final Main plugin;

    public NoVillagerTradesCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {

            //Check if the CommandSender sent any command arguments
            if (args == null || args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Invalid usage!");
                return true;
            }

            //Check if the CommandSender has permission to use the command
            if (!sender.hasPermission("novillagertrades.admin")) {
                sender.sendMessage(ChatColor.RED + "Insufficient permissions!");
                return true;
            }

            //Check if the CommandSender sent "reload" as an argument
            if (args[0].equalsIgnoreCase("reload")) {

                //Reload the config.yml
                plugin.reloadConfig();

                //Get the reload message from the config.yml
                String message = plugin.getConfig().getString("messages.reload");

                //Check if the message is valid
                if (message == null) {
                    message = "messages.reload";
                }

                //Send the message to the CommandSender
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

                return true;
            }

            //Otherwise, send the unknown command message
            sender.sendMessage(ChatColor.RED + "Unknown command!");

        } else {
            sender.sendMessage(ChatColor.RED + "Only players may use this command!");
        }

        return true;
    }

}
