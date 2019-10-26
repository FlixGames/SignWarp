package net.flixgames.signwarp.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class WarpManager {

    public static void setWarp(String warpname, Player player) {

        String world = player.getWorld().getName();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        float yaw = player.getLocation().getYaw();
        float pitch = player.getLocation().getPitch();

        FileManager.cfg.set(warpname+".world", world);
        FileManager.cfg.set(warpname+".x", x);
        FileManager.cfg.set(warpname+".y", y);
        FileManager.cfg.set(warpname+".z", z);
        FileManager.cfg.set(warpname+".yaw", yaw);
        FileManager.cfg.set(warpname+".pitch", pitch);

        List<String> warps = Data.getWarps();
        warps.add(warpname);

        FileManager.cfg.set("Warps", warps);
        FileManager.save();

        player.sendMessage(Data.prefix + "Du hast den Warp §6" + warpname + " §aerfolgreich §7gesetzt");

    }

    public static void removeWarp(String warpname) {
        FileManager.cfg.set(warpname, null);

        List<String> warps = Data.getWarps();
        warps.remove(warpname);

        FileManager.cfg.set("Warps", warps);
        FileManager.save();
    }

    public static Location getWarp(String warpname) {
        Location location;

        if(!FileManager.cfg.contains(warpname)) {
            return location = null;
        }

        String world = FileManager.cfg.getString(warpname+".world");
        double x = FileManager.cfg.getDouble(warpname+".x");
        double y = FileManager.cfg.getDouble(warpname+".y");
        double z = FileManager.cfg.getDouble(warpname+".z");
        float yaw = (float) FileManager.cfg.getDouble(warpname+".yaw");
        float pitch = (float) FileManager.cfg.getDouble(warpname+".pitch");

        location = new Location(Bukkit.getWorld(world), x, y, z);
        location.setYaw(yaw);
        location.setPitch(pitch);

        return location;

    }

}
