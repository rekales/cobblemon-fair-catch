package com.kreidev.cbmnfaircatch.neoforge;

import com.kreidev.cbmnfaircatch.CobblemonFairCatchClient;
import com.kreidev.cbmnfaircatch.CobblemonFairCatch;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

import static com.kreidev.cbmnfaircatch.CobblemonFairCatch.MOD_ID;

@Mod(MOD_ID)
public class CobblemonFairCatchNeoForge {

    public CobblemonFairCatchNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfigNeoForge.SPEC);
        CobblemonFairCatch.init();
        CobblemonFairCatchClient.initClient();
        modEventBus.addListener(CommonConfigNeoForge::onLoad);
        modEventBus.addListener(CommonConfigNeoForge::onReload);
    }
}
