package net.minhperry.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minhperry.Suichat;

public class ChatListener {
    public static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent(receiveCanceled = true, priority = EventPriority.HIGHEST)
    public void onMessageReceived(final ClientChatReceivedEvent event) {

        String unformatted = StringUtils.stripControlCodes(event.message.getUnformattedText());

        if (Suichat.config.hideProfile) {
            if (unformatted.startsWith("You are playing on profile:")) {
                event.setCanceled(true);
            }
        }

        if (Suichat.config.hideGXP) {
            if (unformatted.startsWith("You earned") && unformatted.contains("GEXP")) {
                event.setCanceled(true);
            }
        }
    }
}
