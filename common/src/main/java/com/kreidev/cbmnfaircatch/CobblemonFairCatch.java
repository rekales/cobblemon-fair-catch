package com.kreidev.cbmnfaircatch;

import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import com.cobblemon.mod.common.api.text.TextKt;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.util.PlayerExtensionsKt;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;


@SuppressWarnings("unused")
public class CobblemonFairCatch {
    public static final String MOD_ID = "cbmnfaircatch";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static void init() {
        CobblemonEvents.THROWN_POKEBALL_HIT.subscribe(event -> {
            if (event.getPokeBall().getOwner() instanceof ServerPlayer player
                    && event.getPokemon().getPokemon().isWild()
                    && !PlayerExtensionsKt.isInBattle(player)
            ) {
                PlayerPartyStore party = PlayerExtensionsKt.party(player);
                int highestLevel = 0;
                for (Pokemon pokemon : party) {
                    highestLevel = Math.max(pokemon.getLevel(), highestLevel);
                }

                if (event.getPokemon().getPokemon().getLevel() > highestLevel) {
                    player.sendSystemMessage(TextKt.red(Component.translatable(MOD_ID+".level_too_high")), true);
                    event.cancel();
                }
            }
        });
    }

    public static ResourceLocation resLoc(String path, Object... args) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, String.format(path, args));
    }
}
