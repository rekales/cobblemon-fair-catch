package com.kreidev.cbmnfaircatch;

import com.kreidev.cbmnfaircatch.network.FieldLabNetworkManagerClient;

public class CobblemonFairCatchClient {
    public static void initClient() {
        // NOTE: invoked by NeoForge common entrypoint.
        FieldLabNetworkManagerClient.registerPacketsClient();
    }
}
