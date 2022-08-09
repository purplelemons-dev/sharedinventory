package group.thebasement.plugins.shareinv;

import group.thebasement.plugins.shareinv.commands.PluginCommands;
import group.thebasement.plugins.shareinv.handlers.PlayerHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        getServer().broadcastMessage("Shared Inventory Plugin Enabled!");

        new PlayerHandler(this);

        getCommand("disableshareinv").setExecutor(new PluginCommands());

    }
}
