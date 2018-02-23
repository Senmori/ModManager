package net.senmori.modmanager.message;

import net.senmori.modmanager.ModManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageHandler {

    private static final ModManager plugin = JavaPlugin.getPlugin(ModManager.class);

    public static void sendPluginMessage(PluginMessage message, Player player) {
        player.sendPluginMessage(plugin, message.getChannel(), message.getData());
    }
}
