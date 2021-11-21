package net.minhperry.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minhperry.Suichat;
import net.minhperry.core.Config;
import net.minhperry.utils.Utils;

public class InfrabotListener {

    public static Minecraft mc = Minecraft.getMinecraft();
    public static Config cfg = Suichat.config;

    @SubscribeEvent(receiveCanceled = true, priority = EventPriority.HIGHEST)
    public void onMessageReceived(final ClientChatReceivedEvent event) {

        if (!Utils.isOnHypixel()) return;

        EnumChatFormatting botColor;
        switch (Suichat.config.colorNumber) {
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

        final String message = Utils.removeColorCodes(event.message.getFormattedText())
                .substring(7)
                .replaceAll("\\[.*?\\]","");

        String[] args = message.split(" ");

        String name = Suichat.config.botName.toLowerCase();

        if (args[0].toLowerCase().equals(name)
                || args[1].toLowerCase().equals(name)
                || args[0].toLowerCase().equals(name + ":")
                || args[1].toLowerCase().equals(name + ":")
        ) {
            event.setCanceled(true);

            String[] args2 = message.split(":");

            String name2 = args2[1].substring(3);

            String messageReal = "";

            for (int i = 2; i < args2.length; i++) {
                messageReal += args2[i];

                if (i + 1 != args2.length) {
                    messageReal += ":";
                }
            }

            messageReal = messageReal.substring(1);

            if (cfg.isGonbSupermacy) {
                messageReal = messageReal
                        .replace("gonb", cfg.gonbColor + "gonb§f")
                        .replace("gnob", cfg.gonbColor + "gnob§f");
            }


            String nameReal = "";
            String[] argsName = name2.split(" ");

            for (int i = 0; i < argsName.length; i++) {
                nameReal += botColor + argsName[i];
                if (i + 1 != argsName.length) {
                    nameReal += " ";
                }
            }

            if (cfg.isGonbSupermacy) {
                nameReal = nameReal
                        .replace("gonb", cfg.gonbColor + "gonb§f")
                        .replace("gnob", cfg.gonbColor + "gnob§f");
            }

            String toSend = "&r&2Guild &2> "
                    + botColor + "[" + cfg.botPrefix + botColor + "] "
                    + botColor + nameReal + "§r: §r" + messageReal;

            mc.thePlayer.addChatMessage(new ChatComponentText(toSend));
        }


    }

}
