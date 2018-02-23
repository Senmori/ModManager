package net.senmori.modmanager.message;

import com.google.gson.JsonParser;
import net.senmori.modmanager.ModManager;
import org.bukkit.entity.Player;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {

    private ModManager manager;
    public PluginMessageListener(ModManager manager) {
        this.manager = manager;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        Map<String, String> modList = getModData(message);

        manager.getLogger().info("MOD LIST: " + modList.toString());
    }

    private Map<String, String> getModData(byte[] data)
    {
        Map<String, String> mods = new HashMap<>();

        boolean store = false;
        String tempName = null;

        for (int i = 2; i < data.length; store = !store)
        {
            int end = i + data[i] + 1;
            byte[] range = Arrays.copyOfRange(data, i + 1, end);

            String string = new String(range, StandardCharsets.UTF_8);

            if (store)
            {
                mods.put(tempName, string);
            }
            else
            {
                tempName = string;
            }

            i = end;
        }

        return mods;
    }
}
