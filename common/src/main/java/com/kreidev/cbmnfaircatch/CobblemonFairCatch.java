package com.kreidev.cbmnfaircatch;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.kreidev.cbmnfaircatch.network.FieldLabNetworkManager;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;


@SuppressWarnings("unused")
public class CobblemonFairCatch {
    public static final String MOD_ID = "cbmnfaircatch";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        FieldLabNetworkManager.registerPackets();

        CobblemonEvents.THROWN_POKEBALL_HIT.subscribe(event -> {
            LOGGER.warn("Tried");
        });
    }

    public static void initClient() {

    }

    public static ResourceLocation resLoc(String path, Object... args) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, String.format(path, args));
    }
}
