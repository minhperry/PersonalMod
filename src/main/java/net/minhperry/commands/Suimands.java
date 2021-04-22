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
    public String getCommandName() { return "bridgechat"; }

    @Override
    public List<String> getCommandAliases() { return Lists.newArrayList("bc", "bchat"); }

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
            player.addChatMessage(new ChatComponentText(  "§bSuiChat Help and Info" + "\n" +
                    "§bYou are currently running ECX on version " + ModInfo.VERSION + "." + "\n" +
                    "§b--------------------------------------" + "\n" +
                    "§9§l What's new in ECX " + ModInfo.VERSION + " ?" + "\n" +
                    "§b ➜ Added message hiders." + "\n" +
                    "§b ➜ Tweaks Hypixel's default friend/guild join/leave messages." + "\n" +
                    "§b ➜ Added support for Terminal Velocity guild, while still " + "\n" +
                    "§b maintaining support for Infrared guild." + "\n" +
                    "§b--------------------------------------" + "\n" +
                    "§3/bridgechat config/cfg §l➡ Open the configuration menu." + "\n" +
                    "§bYou can also use \"/bc\" or \"/bchat\" as command aliases."
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
                                EnumChatFormatting.RED + "[" +
                                EnumChatFormatting.AQUA + "SUICHAT" +
                                EnumChatFormatting.RED + "] " +
                                EnumChatFormatting.GREEN + "Wrong command you baldhead!"
                        )
                );
                break;
            case "bald":
            case "fat":
            case "sex":
                player.addChatMessage(new
                                ChatComponentText(
                                EnumChatFormatting.RED + "[" +
                                        EnumChatFormatting.AQUA + "SUICHAT" +
                                        EnumChatFormatting.RED + "] " +
                                        EnumChatFormatting.GREEN + player.getName() +
                                        ", no u!"
                        )
                );
                break;
            case "ez":
                /*
                player.addChatMessage((IChatComponent) new ChatComponentText("§a§lClick here to copy ez.")
                        .getChatStyle()
                        .setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText("Clicky!")))
                        .setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/suichatez"))
                );
                 */
                player.addChatMessage(new ChatComponentText("§cThis command is currently disabled"));
                break;
        }
    }
}
