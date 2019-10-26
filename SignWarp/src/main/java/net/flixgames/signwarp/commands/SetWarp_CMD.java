package net.flixgames.signwarp.commands;

import net.flixgames.signwarp.SignWarp;
import net.flixgames.signwarp.utils.Data;
import net.flixgames.signwarp.utils.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarp_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(sender.hasPermission("signwarp.setwarp")) {
                if(args.length == 1) {
                    WarpManager.setWarp(args[0], player);
                    SignWarp.loadWarps();
                } else {
                    player.sendMessage(Data.prefix + "§c/setwarp <Name>");
                }
            } else {
                player.sendMessage(Data.noperms);
            }
        }
        return false;
    }
}
