package net.flixgames.signwarp;

import net.flixgames.signwarp.commands.RemoveWarp_CMD;
import net.flixgames.signwarp.commands.SetWarp_CMD;
import net.flixgames.signwarp.commands.Warps_CMD;
import net.flixgames.signwarp.listener.BlockBreakListener;
import net.flixgames.signwarp.listener.SignChangeListener;
import net.flixgames.signwarp.listener.SignInteractListener;
import net.flixgames.signwarp.utils.Data;
import net.flixgames.signwarp.utils.WarpManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class SignWarp extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
        registerListener();
        loadWarps();
        sendMessage(true);
    }

    @Override
    public void onDisable() {
        sendMessage(false);
    }

    private void registerCommands() {
        getCommand("removewarp").setExecutor(new RemoveWarp_CMD());
        getCommand("setwarp").setExecutor(new SetWarp_CMD());
        getCommand("warps").setExecutor(new Warps_CMD());
    }

    private void registerListener() {
        new SignChangeListener(this);
        new SignInteractListener(this);
        new BlockBreakListener(this);
    }

    private void sendMessage(boolean enable) {
        Bukkit.getConsoleSender().sendMessage(getSpacer("§4§lFlixGames"));
        Bukkit.getConsoleSender().sendMessage("§6Plugin §7» §6" + getDescription().getName());
        Bukkit.getConsoleSender().sendMessage("§bDeveloper §7» §b" + getDescription().getAuthors().toString().replace("[", "").replace("]", ""));
        Bukkit.getConsoleSender().sendMessage("§4§lIn order of §7» §4§lFlixGames");
        Bukkit.getConsoleSender().sendMessage("§aVersion §7» §a" + getDescription().getVersion());
        if(enable) {
            Bukkit.getConsoleSender().sendMessage("§7Status » §aenabled");
        } else {
            Bukkit.getConsoleSender().sendMessage("§7Status » §cdisabled");
        }
        Bukkit.getConsoleSender().sendMessage(getSpacer("§4§lFlixGames"));
    }

    private String getSpacer(String name) {
        return "§8§m}----------[§r " + name + " §8§m]----------{";
    }

    public static void loadWarps() {
        List<String> warps = Data.getWarps();
        if(warps.isEmpty()) {
            return;
        }
        Data.warps.clear();
        for(String warp : warps) {
            Data.warps.put(warp, WarpManager.getWarp(warp));
            Bukkit.getConsoleSender().sendMessage("§7Location §6" + warp + " §7loaded §asuccessfully");
        }
    }

}
