package net.senmori.modmanager.forge;

import net.senmori.modmanager.message.PluginMessage;

import java.util.regex.Pattern;

public final class ForgeConstants {

    public static final String FORGE_RESTOER = "FORGE";

    public static final String FML_TAG = "FML";
    public static final String FML_HANDSHAKE_TAG = "FML|HS";
    public static final String FML_REGISTER = "REGISTER";

    public static final String FML_HANDSHAKE_TOKEN = "\0FML\0";

    public static final PluginMessage FML_RESET_HANDSHAKE = new PluginMessage( FML_HANDSHAKE_TAG, new byte[] {-2, 0} );

    public static final PluginMessage FML_ACK = new PluginMessage( FML_HANDSHAKE_TAG, new byte[] {-1, 0} );

    public static final PluginMessage FML_START_CLIENT_HANDSHAKE = new PluginMessage( FML_HANDSHAKE_TAG, new byte[] {0, 1} );

    public static final PluginMessage FML_START_SERVER_HANDSHAKE = new PluginMessage( FML_HANDSHAKE_TAG, new byte[] {1, 1} );

    public static final PluginMessage FML_EMPTY_MOD_LIST = new PluginMessage( FML_HANDSHAKE_TAG, new byte[] {2, 0} );

    /**
     * Regex to use to scrape the version information from a FML handshake.
     */
    public static final Pattern FML_HANDSHAKE_VERSION_REGEX = Pattern.compile( "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)" );
}
