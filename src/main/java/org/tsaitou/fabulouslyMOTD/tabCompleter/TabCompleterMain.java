package org.tsaitou.fabulouslyMOTD.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.tsaitou.fabulouslyMOTD.FabulouslyMOTD;
import org.tsaitou.fabulouslyMOTD.libs.Configuration;

import java.util.*;

public final class TabCompleterMain implements TabCompleter {
    private final FabulouslyMOTD plugin;
    private final static List<String> commands = Arrays.asList("add", "append", "delete", "join", "pop", "reload", "remove");
    private final static List<String> popping = Arrays.asList("delete", "pop", "remove");

    public TabCompleterMain(FabulouslyMOTD plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
//        if (args.length == 1) {
//            List<String> suggestions = new ArrayList<>();
//            for (String d : commands) {
//                if (d.startsWith(args[0].toLowerCase()) || args[0].equalsIgnoreCase(d)) {
//                    suggestions.add(d);
//                }
//            }
//            return suggestions;
//        }
//        return commands;
        return switch (args.length) {
            case 1 -> {
                List<String> suggestions = new ArrayList<>();
                for (String d : commands) {
                    if (d.startsWith(args[0].toLowerCase()) || args[0].equalsIgnoreCase(d)) {
                        suggestions.add(d);
                    }
                }
                yield suggestions;
            }
            case 2 -> {
                if (popping.contains(args[0])) {
                    final Configuration config = new Configuration(plugin);
                    List<String> suggestions = new ArrayList<>();
                    List<String> motds = config.getMotd();
                    for (String d : motds) {
                        if (d.startsWith(args[1].toLowerCase()) || args[1].equalsIgnoreCase(d)) {
                            suggestions.add(d);
                        }
                    }
                    yield suggestions;
                }
                yield null;
            }
            default -> null;
        };
    }
}
