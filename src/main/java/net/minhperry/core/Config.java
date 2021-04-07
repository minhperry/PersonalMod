package net.minhperry.core;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.*;
import net.minecraft.util.EnumChatFormatting;

import java.io.File;

public class Config extends Vigilant {

    @Property(
            type = PropertyType.SELECTOR,
            name = "Prefix",
            description = "Prefix for the bot.",
            category = "Preferences",
            options = {"BOT", "DISCORD"}
    )
    public String prefix = "BOT";

    @Property(
            type = PropertyType.SELECTOR,
            name = "Color",
            description = "Color of the bot.",
            category = "Preferences",
            options = {
                    "\u00a70BLACK",
                    "\u00a71DARK_BLUE",
                    "\u00a72DARK_GREEN",
                    "\u00a73DARK_AQUA",
                    "\u00a74DARK_RED",
                    "\u00a75DARK_PURPLE",
                    "\u00a76GOLD",
                    "\u00a77GRAY",
                    "\u00a78DARK_GRAY",
                    "\u00a79BLUE",
                    "\u00a7aGREEN",
                    "\u00a7bAQUA",
                    "\u00a7cRED",
                    "\u00a7dLIGHT_PURPLE",
                    "\u00a7eYELLOW",
                    "\u00a7fWHITE"
            }
    )
    public int colorCode = 13;

    @Property(
            type = PropertyType.SWITCH,
            name = "Colon Type",
            description = "ON for Colon (:), OFF for Arrow (>)",
            category = "Preferences"
    )
    public boolean isColon = true;

    public Config() {
        super(new File("./config/suimod/suifig.toml"));
        initialize();
    }

}
