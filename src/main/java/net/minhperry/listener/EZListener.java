package net.minhperry.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EZListener {

    public static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onSendChatMessage(SendChatMessageEvent event) {
        if (event.message.startsWith("/suichatez") && !event.addToChat) {
            mc.thePlayer.addChatMessage(new ChatComponentText("§aCopied!"));
            GuiScreen.setClipboardString("e\u1CBCz");
            event.setCanceled(true);
        }
    }
}
