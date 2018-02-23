package net.senmori.modmanager.message;

import java.nio.charset.StandardCharsets;

public class PluginMessage {

    private String channel;
    private byte[] data;

    public PluginMessage(String channel, byte[] data) {
        this.channel = channel;
        this.data = data;
    }

    public String getChannel() {
        return channel;
    }

    public byte[] getData() {
        return data;
    }

    public String getDataString() {
        return new String(data, StandardCharsets.UTF_8);
    }
}
