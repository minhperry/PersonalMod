package net.minhperry.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;

public class Utils {

    private static final Minecraft mc = Minecraft.getMinecraft();

    // Credit to Skytils
    public static boolean isOnHypixel() {
        try {
            if (mc != null && mc.theWorld != null && !mc.isSingleplayer()) {
                if (mc.thePlayer != null && mc.thePlayer.getClientBrand() != null) {
                    if (mc.thePlayer.getClientBrand().toLowerCase().contains("hypixel")) return true;
                }
                if (mc.getCurrentServerData() != null) return mc.getCurrentServerData().serverIP.toLowerCase().contains("hypixel");
            }
            return false;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Taken from Danker's Skyblock Mod under GPL 3.0 license
     * https://github.com/bowser0000/SkyblockMod/blob/master/LICENSE
     * @author bowser0000
     */
    public static boolean checkForGamemode(String gamemode) {
        if (isOnHypixel()) {
            ScoreObjective scoreboardObj = mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1);
            if (scoreboardObj != null) {
                String scObjName = ScoreboardUtils.cleanSB(scoreboardObj.getDisplayName());
                if (scObjName.contains(gamemode)) {
                    return true;
                }
            }
        }
        return false;
    }

}
