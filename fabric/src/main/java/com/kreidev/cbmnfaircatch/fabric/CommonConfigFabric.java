package com.kreidev.cbmnfaircatch.fabric;

import com.kreidev.cbmnfaircatch.CobblemonFairCatch;
import eu.midnightdust.lib.config.MidnightConfig;

public class CommonConfigFabric extends MidnightConfig {
    public static final String COMMON = "common";

    static void loadConfigs() {
        MidnightConfig.init(CobblemonFairCatch.MOD_ID, CommonConfigFabric.class);
    }
}
