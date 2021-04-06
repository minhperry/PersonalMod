package net.minhperry.suichat.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatListener {

    public static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent(receiveCanceled = true, priority = EventPriority.HIGHEST)
    public void onMessageReceived(final ClientChatReceivedEvent event) {

        // if (!Utils.isOnHypixel()) return;

        final String message = event.message.getUnformattedText();
        /*
        * tellraw @a [{"text":"Guild > ","color":"dark_green"},{"text":"[VIP] Suibot ","color":"green"},{"text":"[exGM]","color":"yellow"},{"text":": bald: bald","color":"white"}]
        * */

        // Ingame
        // §2Guild > §a[VIP] Suibot §e[exGM]§f: gnob: -------

        if (message.startsWith("Guild > [VIP] Suibot [exGM]:") || message.startsWith("§2Guild > §a[VIP] Suibot §e[exGM]§f:")) {
            event.setCanceled(true);
            // mc.thePlayer.addChatMessage(new ChatComponentText("Old text: " + message));
            System.out.println("Old text: " + message);

            String[] msg = message.trim().split("\\s*:\\s*");
            String sender = EnumChatFormatting.LIGHT_PURPLE + msg[1] + EnumChatFormatting.WHITE;
            String guild = EnumChatFormatting.DARK_GREEN + "Guild > ";
            String splittedMessages = "";

            for (int i = 2; i < msg.length; i++) {
                if (i == msg.length - 1)
                    splittedMessages = splittedMessages.concat(msg[i]);
                else
                    splittedMessages = splittedMessages.concat(msg[i]).concat(": ");
            }

            final String toSend = guild + sender + ": " + splittedMessages;

            mc.thePlayer.addChatMessage(new ChatComponentText(toSend));
        }
    }
}
