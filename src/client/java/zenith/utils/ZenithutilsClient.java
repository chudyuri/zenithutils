package zenith.utils;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientChunkEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ZenithutilsClient implements ClientModInitializer {

    private static boolean onZenith = false;

    @Override
    public void onInitializeClient() {
        ClientChunkEvents.CHUNK_LOAD.register((clientWorld, chunk) -> {
            boolean zenith = clientWorld.getRegistryKey().getValue().getPath().equals("zenith");

            if (zenith && !onZenith) {
                onZenith = true;

                MinecraftClient mc = MinecraftClient.getInstance();
                if (mc.player != null) {
                    mc.player.sendMessage(Text.literal("You are now on the Zenith Shard!"), false);
                }
            } else if (!zenith) {
                onZenith = false;
            }
        });
    }
}
