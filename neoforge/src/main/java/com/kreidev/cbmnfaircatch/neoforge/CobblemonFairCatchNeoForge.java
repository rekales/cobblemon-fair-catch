package com.kreidev.cbmnfaircatch.neoforge;

import com.kreidev.cbmnfaircatch.CobblemonFairCatch;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

import static com.kreidev.cbmnfaircatch.CobblemonFairCatch.MOD_ID;

@Mod(MOD_ID)
public class CobblemonFairCatchNeoForge {

    public CobblemonFairCatchNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfigNeoForge.SPEC);
        CobblemonFairCatch.init();
        modEventBus.addListener(CommonConfigNeoForge::onLoad);
        modEventBus.addListener(CommonConfigNeoForge::onReload);
    }
}
