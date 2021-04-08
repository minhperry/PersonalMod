package net.minhperry.core;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.*;
import net.minecraft.util.EnumChatFormatting;

import java.io.File;

public class Config extends Vigilant {

    @Property(
            type = PropertyType.SELECTOR,
            name = "Bot Color",
            description = "Color of the bot.",
            category = "Suibot",
            subcategory = "Addons",
            options = {
                    "§0Black",
                    "§1Dark Blue",
                    "§2Dark Green",
                    "§3Dark Aqua",
                    "§4Dark Red",
                    "§5Dark Purple",
                    "§6Gold",
                    "§7Gray",
                    "§8Dark Gray",
                    "§9Blue",
                    "§aGreen",
                    "§bAqua",
                    "§cRed",
                    "§dLight Purple",
                    "§eYellow",
                    "§fWhite"
            }
    )
    public int colorCode = 13;

    @Property(
            type = PropertyType.SELECTOR,
            name = "Bot Prefix",
            description = "Prefix for the bot.",
            category = "Suibot",
            subcategory = "Addons",
            options = {"BOT", "DISCORD", "BRIDGE", "BALD"}
    )
    public int prefix = 0;

    @Property(
            type = PropertyType.SWITCH,
            name = "Colon Type",
            description = "ON for Colon (:).\nOFF for Arrow (>).",
            category = "Suibot",
            subcategory = "Addons"
    )
    public boolean isColon = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Fancier Guild Join/Leave Message",
            description = "Tweaks the default guild join/leave message.",
            category = "General Chat",
            subcategory = "Tweaks"
    )
    public boolean isGuildFancier = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Fancier Friend Join/Leave Message",
            description = "Tweaks the default friend join/leave message.",
            category = "General Chat",
            subcategory = "Tweaks"
    )
    public boolean isFriendFancier = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "ArabicDuck Hider",
            description = "Hide all messages from ArabicDuck",
            category = "Hiders",
            subcategory = "QUADRUPLE SHINY BALD FAT"
    )
    public boolean hideDuck = false;

    @Property(
            type = PropertyType.TEXT,
            name = "EZ",
            description = "§b[DISABLED] §r§fUse \"/suichat ez\" to copy the word into chat.",
            category = "General Chat",
            subcategory = "Tweaks"
    )
    public String ez = "";

    @Property(
            type = PropertyType.SWITCH,
            name = "Housing Join/Leave Message",
            description = "Hide the annoying chat messages in Housing.",
            category = "Hiders",
            subcategory = "Housing"
    )
    public boolean hideHousingMsg = false;

    public Config() {
        super(new File("./config/suimod/suifig.toml"));
        initialize();
    }

}
