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

public class SuibotListener {

    public static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent(receiveCanceled = true, priority = EventPriority.HIGHEST)
    public void onMessageReceived(final ClientChatReceivedEvent event) {

        if (!Utils.isOnHypixel()) return;

        final String message = StringUtils.stripControlCodes(event.message.getUnformattedText());

        String colon = Suichat.config.isColon ? " : " : " > ";
        EnumChatFormatting botColor;
        switch (Suichat.config.colorCode) {
            case 0:
                botColor = EnumChatFormatting.BLACK;
                break;
            case 1:
                botColor = EnumChatFormatting.DARK_BLUE;
                break;
            case 2:
                botColor = EnumChatFormatting.DARK_GREEN;
                break;
            case 3:
                botColor = EnumChatFormatting.DARK_AQUA;
                break;
            case 4:
                botColor = EnumChatFormatting.DARK_RED;
                break;
            case 5:
                botColor = EnumChatFormatting.DARK_PURPLE;
                break;
            case 6:
                botColor = EnumChatFormatting.GOLD;
                break;
            case 7:
                botColor = EnumChatFormatting.GRAY;
                break;
            case 8:
                botColor = EnumChatFormatting.DARK_GRAY;
                break;
            case 9:
                botColor = EnumChatFormatting.BLUE;
                break;
            case 10:
                botColor = EnumChatFormatting.GREEN;
                break;
            case 11:
                botColor = EnumChatFormatting.AQUA;
                break;
            case 12:
                botColor = EnumChatFormatting.RED;
                break;
            case 13:
                botColor = EnumChatFormatting.LIGHT_PURPLE;
                break;
            case 14:
                botColor = EnumChatFormatting.YELLOW;
                break;
            case 15:
            default:
                botColor = EnumChatFormatting.WHITE;
                break;
        }

        String botName;
        switch (Suichat.config.prefix) {
            case 0:
            default:
                botName = "BOT";
                break;
            case 1:
                botName = "DISCORD";
                break;
            case 2:
                botName = "BRIDGE";
                break;
            case 3:
                botName = "BALD";
                break;
        }

        if (message.startsWith("Guild > [VIP] Suibot [exGM]:")) {
            event.setCanceled(true);

            String[] msg = message.trim().split("\\s*:\\s*");
            String sender = botColor + "[" + botName + "] " + msg[1] + "§f";
            String guild = "§2Guild > ";
            String splittedMessages = "";

            for (int i = 2; i < msg.length; i++) {
                if (i == msg.length - 1)
                    splittedMessages = splittedMessages.concat(msg[i]);
                else
                    splittedMessages = splittedMessages.concat(msg[i]).concat(": ");
            }

            final String toSend = guild + sender + colon + splittedMessages;

            mc.thePlayer.addChatMessage(new ChatComponentText(toSend));
        }
    }
}
