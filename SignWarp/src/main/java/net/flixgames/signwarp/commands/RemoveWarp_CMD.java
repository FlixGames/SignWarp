package net.flixgames.signwarp.commands;

import net.flixgames.signwarp.SignWarp;
import net.flixgames.signwarp.utils.Data;
import net.flixgames.signwarp.utils.FileManager;
import net.flixgames.signwarp.utils.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class RemoveWarp_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("signwarp.removewarp")) {
                if(args.length == 1) {
                    if(FileManager.cfg.contains(args[0])) {
                        WarpManager.removeWarp(args[0]);
                        SignWarp.loadWarps();
                        player.sendMessage(Data.prefix + "Der Warp §6" + args[0] + " §7wurde §centfernt");
                    } else {
                        player.sendMessage(Data.prefix + "§cDieser Warp existiert nicht");
                    }
                } else {
                    player.sendMessage(Data.prefix + "§c/removewarp <Name>");
                }
            } else {
                player.sendMessage(Data.noperms);
            }
        } else if(sender instanceof ConsoleCommandSender) {
            if(args.length == 1) {
                if(FileManager.cfg.contains(args[0])) {
                    WarpManager.removeWarp(args[0]);
                    SignWarp.loadWarps();
                    sender.sendMessage(Data.prefix + "Der Warp §6" + args[0] + " §7wurde §centfernt");
                } else {
                    sender.sendMessage(Data.prefix + "§cDieser Warp existiert nicht");
                }
            } else {
                sender.sendMessage(Data.prefix + "§c/removewarp <Name>");
            }
        }
        return false;
    }
}
