package com.kreidev.cbmnfaircatch.fabric;

import com.kreidev.cbmnfaircatch.CobblemonFairCatchClient;
import net.fabricmc.api.ClientModInitializer;

public class CobblemonFairCatchFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CobblemonFairCatchClient.initClient();
    }
}