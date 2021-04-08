package net.minhperry.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minhperry.Suichat;
import net.minhperry.utils.Utils;

public class JoinLeaveListener {
    public static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent(receiveCanceled = true, priority = EventPriority.HIGHEST)
    public void onMessageReceived(final ClientChatReceivedEvent event) {

        // Guild
        if (Suichat.config.isFancier) {
            String message = StringUtils.stripControlCodes(event.message.getUnformattedText());
            if (message.endsWith("joined.") || message.endsWith("left.")) {
                event.setCanceled(true);

                String[] msg = event.message.getFormattedText().split(" ");
                String user = msg[2];
                String indicator;

                if (message.endsWith("joined."))
                    indicator = "§aG+";
                else
                    indicator = "§cG-";

                String finalMsg = "§2[" + indicator + "§2] " + user;
                mc.thePlayer.addChatMessage(new ChatComponentText(finalMsg));
            }
        }

        // Housing
        if (Suichat.config.hideHousingMsg) {
            String message = StringUtils.stripControlCodes(event.message.getUnformattedText());
            if (Utils.checkForGamemode("HOUSING"))
                if (message.endsWith("the world.")) event.setCanceled(true);
        }
    }
}
