package net.minhperry.commands;

import club.sk1er.mods.core.ModCore;
import com.google.common.collect.Lists;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minhperry.ModInfo;
import net.minhperry.Suichat;

import java.util.List;
import java.util.Locale;

public class Suimands extends CommandBase {

    @Override
    public String getCommandName() { return "suichat"; }

    @Override
    public List<String> getCommandAliases() { return Lists.newArrayList("sc", "sui"); }

    @Override
    public String getCommandUsage(ICommandSender sender) { return "." + getCommandName(); }

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
            player.addChatMessage(new ChatComponentText( "§bSuiChat Help amd Info" + "\n" +
                    EnumChatFormatting.AQUA + "You are currently running Suichat on version " + ModInfo.VERSION + "." +
                    EnumChatFormatting.BLUE + "§9--------------------------------------" + "\n" +
                    EnumChatFormatting.DARK_AQUA + "What's new in Suichat " + ModInfo.VERSION + " ?" + "\n" +
                    EnumChatFormatting.AQUA + " ➜ §lCustomizability! §r§bYou can now edit bot prefix and bot color!" + "\n" +
                    EnumChatFormatting.AQUA + "§b ➜ Run \".suichat config\" to open configuration menu." + "\n" +
                    EnumChatFormatting.BLUE + "§9--------------------------------------" + "\n" +
                    EnumChatFormatting.AQUA + " .suichat config §l ➡ §fOpen the configuration menu." + "\n" +
                    EnumChatFormatting.AQUA + " You can also use \".sc\" or \".sui\" as command aliases."
            ));
            return;
        }
        String subcommand = args[0].toLowerCase(Locale.ENGLISH);
        switch (subcommand) {
            case "config":
                ModCore.getInstance().getGuiHandler().open(Suichat.config.gui());
                break;
            default:
                player.addChatMessage(new
                        ChatComponentText(
                                EnumChatFormatting.RED + "[" +
                                EnumChatFormatting.AQUA + "SUICHAT" +
                                EnumChatFormatting.RED + "] " +
                                EnumChatFormatting.GREEN + "Enter something you baldhead!"
                        )
                );
        }
    }
}
