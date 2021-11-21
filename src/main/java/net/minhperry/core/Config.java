package net.minhperry.core;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.*;

import net.minecraft.util.EnumChatFormatting;

import java.io.File;

public class Config extends Vigilant {

    @Property(
            type = PropertyType.SLIDER,
            name = "Bot Color",
            description = "Color of the bot",
            category = "Chat Bridge",
            subcategory = "Addons",
            min = 0, max = 15
    )
    public int colorNumber = 13;

    @Property(
            type = PropertyType.TEXT,
            name = "Color helper",
            description = "Colors: \n§00 §11 §22 §33 §44 §55 §66 §77 \n §88 §99 §a10 §b11 §c12 §d13 §e14 §f15",
            category = "Chat Bridge",
            subcategory = "Addons"
    )
    public String empty = "";

    @Property(
            type = PropertyType.TEXT,
            name = "Bot Prefix",
            description = "Prefix for the bot.",
            category = "Chat Bridge",
            subcategory = "Addons",
            placeholder = "Put your bot prefix here!"
    )
    public String botPrefix = "BOT";

    @Property(
            type = PropertyType.TEXT,
            name = "Bot Name",
            description = "Name of the bot to be replaced.",
            category = "Chat Bridge",
            subcategory = "Addons"
    )
    public String botName = "InfraBot";

    @Property(
            type = PropertyType.TEXT,
            name = "Seperator",
            description = "Seperator between the sender and the message. Default is \">\".",
            category = "Chat Bridge",
            subcategory = "Addons"
    )
    public String seperator = ">";

    @Property(
            type = PropertyType.SWITCH,
            name = "Gonb Supermacy",
            description = "Give every gonb a special color.",
            category = "Chat Bridge",
            subcategory = "Gonb"
    )
    public boolean isGonbSupermacy = false;

    @Property(
            type = PropertyType.SLIDER,
            name = "Gonb Color",
            description = "Color of the gonbs",
            category = "Chat Bridge",
            subcategory = "Gonb",
            min = 0, max = 15
    )
    public int gonbColor = 12;

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

    public Config() {
        super(new File("./config/suimod/config.toml"));
        initialize();
        // Class clz = Config.class;
        // addDependency("isGonbSupermacy", clz.getDeclaredField("gonbColor"));
    }


}
