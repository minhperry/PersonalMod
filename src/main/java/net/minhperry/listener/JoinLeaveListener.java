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
        if (Suichat.config.isGuildFancier) {
            String message = StringUtils.stripControlCodes(event.message.getUnformattedText());

            String indicator = "";

            if (Utils.isMatch(message, "Guild > ([\\w]+) left."))
                indicator = "§c-";
            if (Utils.isMatch(message, "Guild > ([\\w]+) joined."))
                indicator = "§a+";

            // format
            // Guild > Name activity.

            String msg[] = event.message.getFormattedText().split(" ");
            String user = msg[2];

            String finalMsg = "§2Guild > §f[" + indicator + "§f] " + user;
            mc.thePlayer.addChatMessage(new ChatComponentText(finalMsg));
        }

        // IN RECONSIDERATION
        /*
        if (Suichat.config.isGuildFancier) {
            String message = StringUtils.stripControlCodes(event.message.getUnformattedText());

            String indicator;

            // 7 -> l-5 = left.     7 -> l-7 = joined.
            if (
                    message.substring(7, message.length() - 5).split(" ").length == 1
            ) { // left.
                indicator = "§c-";
            } else { // joined
                indicator = "§c+";
            }

            String[] msg = event.message.getFormattedText().split(" ");
            String user = msg[2];

            String finalMsg = "§2Guild > §f[" + indicator + "§f] " + user;
            mc.thePlayer.addChatMessage(new ChatComponentText(finalMsg));
        }
        */

        // Friend
        if (Suichat.config.isFriendFancier) {
            String message = StringUtils.stripControlCodes(event.message.getUnformattedText());

            String indicator = "";

            if (Utils.isMatch(message, "Friend > ([\\w]+) left."))
                indicator = "§c-";
            if (Utils.isMatch(message, "Friend > ([\\w]+) joined."))
                indicator = "§a+";

            // format
            // Guild > Name activity.

            String msg[] = event.message.getFormattedText().split(" ");
            String user = msg[2];

            String finalMsg = "§2Guild > §f[" + indicator + "§f] " + user;
            mc.thePlayer.addChatMessage(new ChatComponentText(finalMsg));
        }

        // Housing
        if (Suichat.config.hideHousingMsg) {
            String message = StringUtils.stripControlCodes(event.message.getUnformattedText());
            if (Utils.checkForGamemode("HOUSING"))
                if (message.endsWith("the world.")) event.setCanceled(true);
        }
    }
}
