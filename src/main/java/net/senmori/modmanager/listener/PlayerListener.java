package net.senmori.modmanager.listener;

import net.senmori.modmanager.ModManager;
import net.senmori.modmanager.forge.ForgeConstants;
import net.senmori.modmanager.message.MessageHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerListener implements Listener {

    private ModManager manager;
    public PlayerListener(ModManager manager) {
        this.manager = manager;
        Bukkit.getPluginManager().registerEvents(this, manager);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        new BukkitRunnable() {
            @Override
            public void run() {
                final Player player = event.getPlayer();
                MessageHandler.sendPluginMessage(ForgeConstants.FML_RESET_HANDSHAKE, player);
                MessageHandler.sendPluginMessage(ForgeConstants.FML_START_CLIENT_HANDSHAKE, player);
                MessageHandler.sendPluginMessage(ForgeConstants.FML_EMPTY_MOD_LIST, player);
            }
        }.runTaskLater(manager, 10L);
    }
}
