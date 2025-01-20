package org.tsaitou.fabulouslyMOTD.command.subcommandsMain;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.tsaitou.fabulouslyMOTD.FabulouslyMOTD;
import org.tsaitou.fabulouslyMOTD.libs.SubCommand;

public final class SubCommandReload extends SubCommand {
    public SubCommandReload(CommandSender sender, Command command, String label, String[] args, FabulouslyMOTD plugin) {
        super(sender, command, label, args, plugin);
    }

    @Override
    public boolean run() {
        final FabulouslyMOTD plugin = getPlugin();
        plugin.getLogger().info("Config reloading...");
        plugin.reloadConfig();
        plugin.getLogger().info("Config reloaded.");
        getSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[FMOTD]&r Config reloaded!"));
        return true;
    }
}
