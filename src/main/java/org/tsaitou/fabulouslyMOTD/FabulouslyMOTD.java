package org.tsaitou.fabulouslyMOTD;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.tsaitou.fabulouslyMOTD.command.CommandMain;
import org.tsaitou.fabulouslyMOTD.events.EventPlayerPing;
import org.tsaitou.fabulouslyMOTD.tabCompleter.TabCompleterMain;

import java.util.Objects;

public final class FabulouslyMOTD extends JavaPlugin {
    public boolean hasPermissions(CommandSender sender) {
        return (sender instanceof Player) ? sender.hasPermission("fmotd.admin") : sender instanceof ConsoleCommandSender;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventPlayerPing(this), this);
        Objects.requireNonNull(getCommand("FabulouslyMOTD")).setExecutor(new CommandMain(this));
        Objects.requireNonNull(getCommand("FabulouslyMOTD")).setTabCompleter(new TabCompleterMain(this));
        saveDefaultConfig();
        getLogger().info("Plugin has enabled.");
        try {
            reloadConfig();
            getLogger().info("Config loaded.");
        } catch (Exception e) {
            getLogger().warning("Config file is not loaded. Please use /fmotd reload to load config file.");
            getLogger().warning(e.toString());
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has disabled.");
    }
}
