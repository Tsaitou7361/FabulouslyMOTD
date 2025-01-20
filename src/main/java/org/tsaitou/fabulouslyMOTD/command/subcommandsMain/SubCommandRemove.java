package org.tsaitou.fabulouslyMOTD.command.subcommandsMain;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.tsaitou.fabulouslyMOTD.FabulouslyMOTD;
import org.tsaitou.fabulouslyMOTD.libs.Configuration;
import org.tsaitou.fabulouslyMOTD.libs.SubCommand;

import java.util.Arrays;

public final class SubCommandRemove extends SubCommand {
    public SubCommandRemove(CommandSender sender, Command command, String label, String[] args, FabulouslyMOTD plugin) {
        super(sender, command, label, args, plugin);
    }

    @Override
    public boolean run() {
        Configuration config = new Configuration(getPlugin());

        if (getArgs().length <= 1) {
            getSender().sendMessage("[FMOTD] You specified an empty motd!");
            return true;
        }

        String[] newArgs = Arrays.copyOfRange(getArgs(), 1, getArgs().length);
        StringBuilder motd = new StringBuilder();

        for (String item : newArgs) {
            motd.append(newArgs[newArgs.length - 1].equals(item) ? item : item + " ");
        }

        config.removeMotd(motd.toString());
        final FabulouslyMOTD plugin = getPlugin();

        plugin.getLogger().info("MOTD list updated.");
        getSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[FMOTD]&r Successfully updated motd list!"));
        getSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c- &7") + motd);
        return true;
    }
}
