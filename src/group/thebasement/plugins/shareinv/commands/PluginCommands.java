package group.thebasement.plugins.shareinv.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PluginCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("disableshareinv")) {
            Bukkit.getPluginManager().disablePlugins();
            Bukkit.broadcastMessage("Goodbye...");
            return true;
        }
        return false;
    }
}
