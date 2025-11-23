package com.kreidev.cbmnfaircatch.network;

import com.mojang.serialization.Codec;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;


import static com.kreidev.cbmnfaircatch.CobblemonFairCatch.LOGGER;

// NOTE: Should I verify the packets to check if players using the block?
// NOTE: I maybe shouldn't bother and could make an item version for this questing block.
public class FieldLabNetworkManager {

    public static void registerPackets() {
//        NetworkManager.registerReceiver(
//                NetworkManager.Side.C2S,
//                RerollPacket.TYPE,
//                RerollPacket.STREAM_CODEC,
//                FieldLabNetworkManager::rerollQuest
//        );
//
//        NetworkManager.registerReceiver(
//                NetworkManager.Side.C2S,
//                SubmitPacket.TYPE,
//                SubmitPacket.STREAM_CODEC,
//                FieldLabNetworkManager::submitQuest
//        );
    }

    public static <B extends FriendlyByteBuf, T> StreamCodec<B, T> fromCodec(Codec<T> codec) {
        return new StreamCodec<>() {
            @Override
            public T decode(B buf) {
                CompoundTag tag = buf.readNbt();
                return codec.parse(NbtOps.INSTANCE, tag)
                        .resultOrPartial(error -> LOGGER.error("Decode error: " + error))
                        .orElseThrow();
            }

            @Override
            public void encode(B buf, T value) {
                codec.encodeStart(NbtOps.INSTANCE, value)
                        .resultOrPartial(error -> LOGGER.error("Encode error: " + error))
                        .ifPresent(buf::writeNbt);
            }
        };
    }
}
