package net.senmori.modmanager;

import net.senmori.modmanager.forge.ForgeConstants;
import net.senmori.modmanager.listener.PlayerListener;
import net.senmori.modmanager.message.PluginMessageListener;
import org.bukkit.plugin.java.JavaPlugin;

public class ModManager extends JavaPlugin {


    PluginMessageListener messageListener;

    @Override
    public void onEnable() {
        this.messageListener = new PluginMessageListener(this);

        this.getServer().getMessenger().registerIncomingPluginChannel(this, ForgeConstants.FML_HANDSHAKE_TAG, messageListener);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, ForgeConstants.FML_HANDSHAKE_TAG);

        new PlayerListener(this);
    }

    @Override
    public void onDisable() {
    }
}
