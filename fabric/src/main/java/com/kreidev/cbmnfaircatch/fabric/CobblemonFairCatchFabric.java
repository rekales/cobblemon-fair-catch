package com.kreidev.cbmnfaircatch.fabric;

import com.kreidev.cbmnfaircatch.CobblemonFairCatch;
import net.fabricmc.api.ModInitializer;

public class CobblemonFairCatchFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CobblemonFairCatch.init();

        CommonConfigFabric.loadConfigs();
    }

}
