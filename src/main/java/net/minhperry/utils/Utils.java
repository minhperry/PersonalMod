package net.minhperry.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.util.StringUtils;
import scala.swing.TextComponent;


public class Utils {

    private static final Minecraft mc = Minecraft.getMinecraft();

    // Credit to suicidejerk

    public static String insensitiveReplace(String fromString, String toReplace, String replacement) {
        String regex = "(?i)(" + toReplace + ")";
        return fromString.replaceAll(regex, replacement);
    }

    public static String removeColorCodes(String fromString) {
        return StringUtils.stripControlCodes(fromString);
    }

    public static String removeColorCodesRegex(String fromString) {
        return fromString.replaceAll("(?i)[&,§][0-9A-FK-OR]", "");
    }

    /*
        // AWAITING IMPLEMENTATION

    public static String makeClickableLinks(String message) {
        StringBuilder partsArr = new StringBuilder("");
        String unformatted = removeColorCodes(message);

        String[] msgArr = message.split(" ");
        String[] msgArrUnformatted = unformatted.split(" ");

        for (int i = 0; i < msgArrUnformatted.length; i++) {
            try {
                new java.net.URL(msgArrUnformatted[i]);

                //                        vvv HERE
                partsArr.append(new TextComponent)
            } catch (Exception e) {
                partsArr.append(msgArr[i] + " ");
            }
        }
    }
    */

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
