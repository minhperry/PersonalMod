package net.minhperry.commands;

import com.google.common.collect.Lists;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minhperry.ModInfo;

import java.util.List;
import java.util.Locale;

public class IronmanAuction extends CommandBase {

    @Override
    public String getCommandName() { return "ironauction"; }

    @Override
    public List<String> getCommandAliases() { return Lists.newArrayList("iah"); }

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
            player.addChatMessage(new ChatComponentText(
                    "§bIronmanAuction: Allows you to get one's auction on Hypixel Skyblock Ironman gamemode."
            ));
            return;
        }
        String playerName = args[0].toLowerCase(Locale.ENGLISH);
    }
}
