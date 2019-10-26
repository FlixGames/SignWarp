package net.flixgames.signwarp.commands;

import net.flixgames.signwarp.utils.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Warps_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                List<String> warps = Data.getWarps();
                if(warps.isEmpty()) {
                    player.sendMessage(Data.prefix + "Es existieren momentan noch §ckeine §7Warps");
                    return false;
                }
                player.sendMessage(Data.prefix + "Liste aller Warps");
                for(String warp : warps) {
                    player.sendMessage(Data.prefix + "- " + warp);
                }
            } else {
                player.sendMessage(Data.prefix + "§c/warps");
            }
        } else if(sender instanceof ConsoleCommandSender){
            if(args.length == 0) {
                List<String> warps = Data.getWarps();
                if(warps.isEmpty()) {
                    sender.sendMessage(Data.prefix + "Es existieren momentan noch §ckeine §7Warps");
                    return false;
                }
                sender.sendMessage(Data.prefix + "Liste aller Warps");
                for(String warp : warps) {
                    sender.sendMessage(Data.prefix + "- " + warp);
                }
            } else {
                sender.sendMessage(Data.prefix + "§c/warps");
            }
        }
        return false;
    }
}
