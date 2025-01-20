// Credit: https://github.com/SleepySpeller/DynamicallyMotd

package org.tsaitou.fabulouslyMOTD.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.jetbrains.annotations.NotNull;
import org.tsaitou.fabulouslyMOTD.FabulouslyMOTD;
import org.tsaitou.fabulouslyMOTD.libs.Configuration;

public final class EventPlayerPing implements Listener {
    private final FabulouslyMOTD plugin;

    public EventPlayerPing(FabulouslyMOTD plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerPing(@NotNull ServerListPingEvent event) {
        final Configuration config = new Configuration(plugin);
        plugin.getLogger().fine("Received a player's ping.");
        event.setMotd(ChatColor.translateAlternateColorCodes('&', config.getMotdRandomly()));
    }
}
