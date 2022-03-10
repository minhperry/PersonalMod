package net.minhperry.commands;

import club.sk1er.mods.core.ModCore;
import com.google.common.collect.Lists;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minhperry.ModInfo;
import net.minhperry.Suichat;

import java.util.List;
import java.util.Locale;

public class Suimands extends CommandBase {

    @Override
    public String getCommandName() { return "personalmod"; }

    @Override
    public List<String> getCommandAliases() { return Lists.newArrayList("pm", "pmod"); }

    @Override
    public String getCommandUsage(ICommandSender sender) { return "/" + getCommandName(); }

    @Override
    public int getRequiredPermissionLevel() { return 0; }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        EntityPlayerSP player = (EntityPlayerSP) sender;
        if (args.length == 0) {
            player.addChatMessage(new ChatComponentText(  "§bHelp and Info" + "\n" +
                    "§bCurrent mod version: " + ModInfo.VERSION + "." + "\n" +
                    "§3/" + getCommandName() + " config/cfg/cf §l➡ Open the configuration menu." + "\n" +
                    "§bYou can also use \"/pm\" or \"/pmod\" as command aliases."
            ));
            return;
        }
        String subcommand = args[0].toLowerCase(Locale.ENGLISH);
        switch (subcommand) {
            case "config":
            case "cfg":
            case "cf":
                ModCore.getInstance().getGuiHandler().open(Suichat.config.gui());
                break;
            default:
            case "":
                player.addChatMessage(new
                        ChatComponentText(
                                EnumChatFormatting.RED + "\\/!\\\\ Wrong command you baldhead!"
                        )
                );
                break;
            case "bald":
            case "fat":
            case "sex":
                player.addChatMessage(new
                                ChatComponentText(
                                        EnumChatFormatting.GREEN + player.getName() +
                                        ", no u!"
                        )
                );
                break;
            case "setkey":
                player.addChatMessage(new ChatComponentText(
                        EnumChatFormatting.YELLOW + "Set Hypixel API key for the IronmanAuction module."
                ));
                if (args.length == 2) {
                    Suichat.config.APIKey = args[1];
                    player.addChatMessage(new ChatComponentText(
                            EnumChatFormatting.AQUA + "API Key set to " + Suichat.config.APIKey + "."
                    ));
                }
                else
                    player.addChatMessage(new ChatComponentText(
                            EnumChatFormatting.RED + "Type something you stupid."
                    ));
        }
    }
}
