package net.minhperry.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minhperry.Suichat;

public class DuckListener {
    public static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent(receiveCanceled = true, priority = EventPriority.HIGHEST)
    public void onMessageReceived(final ClientChatReceivedEvent event) {
        if (Suichat.config.hideDuck) {
            String unformatted = StringUtils.stripControlCodes(event.message.getUnformattedText());
            if (unformatted.contains("ArabicDuck")) {
                event.setCanceled(true);
            }
        }
    }
}
