package org.tsaitou.fabulouslyMOTD.libs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tsaitou.fabulouslyMOTD.FabulouslyMOTD;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public final class Configuration {
    private final FabulouslyMOTD plugin;

    public Configuration(FabulouslyMOTD plugin) {
        this.plugin = plugin;
    }

    public @NotNull List<String> getMotd() {
        return plugin.getConfig().getStringList("motd");
    }

    public void setMotds(List<String> newList) {
        plugin.getConfig().set("motd", newList);
        plugin.saveConfig();
    }

    public @Nullable String getMotd(int index) {
        try {
            return Objects.requireNonNull(plugin.getConfig().getStringList("motd")).get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public String getMotdRandomly() {
        List<String> motds = getMotd();
        Random random = new Random();
        int int_random = random.nextInt(motds.size());

        if (int_random >= motds.size()) {
            int_random -= 1;
        }
        return getMotd(int_random);
    }

    public void addMotd(@NotNull String newMotd) {
        List<String> motds = getMotd();
        motds.add(newMotd);

        setMotds(motds);
    }

    public void removeMotd(@NotNull String itemToRemove) {
        List<String> list = getMotd();
        if (list.remove(itemToRemove)) {
            setMotds(list);
        }
    }
}
