package net.minhperry.core;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.*;

import net.minecraft.util.EnumChatFormatting;

import java.io.File;

public class Config extends Vigilant {

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
            name = "Housing Join/Leave Message",
            description = "Hide the annoying chat messages in Housing.",
            category = "Hiders",
            subcategory = "Housing"
    )
    public boolean hideHousingMsg = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Ironman Auction House",
            description = "Let you view one's auction on Ironman gamemode.",
            category = "Skyblock",
            subcategory = "Skyblock"
    )
    public boolean isIronmanAuctionEnabled = true;

    @Property(
            type = PropertyType.TEXT,
            name = "Ironman Auction House API Key",
            description = "Set your Hypixel API Key.",
            category = "Skyblock",
            subcategory = "Skyblock"
    )
    public String APIKey = "";

    public static Config INSTANCE = new Config();

    public Config() {
        super(new File("./config/suimod/config.toml"));
        initialize();
        Class clz = Config.class;
        addDependency("gonbColor", "isGonbSupermacy");
    }


}
