// Credit: https://github.com/SleepySpeller/DynamicallyMotd

package org.tsaitou.fabulouslyMOTD.libs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.tsaitou.fabulouslyMOTD.FabulouslyMOTD;

public abstract class SubCommand {
    private final CommandSender sender;
    private final Command command;
    private final String label;
    private final String[] args;
    private final FabulouslyMOTD plugin;

    public SubCommand(CommandSender sender, Command command, String label, String[] args, FabulouslyMOTD plugin) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
        this.plugin = plugin;
    }


    public CommandSender getSender() {
        return sender;
    }

    @SuppressWarnings("unused")
    public Command getCommand() {
        return command;
    }

    @SuppressWarnings("unused")
    public String getLabel() {
        return label;
    }

    public String[] getArgs() {
        return args;
    }

    public FabulouslyMOTD getPlugin() {
        return plugin;
    }

    public abstract boolean run();
}
