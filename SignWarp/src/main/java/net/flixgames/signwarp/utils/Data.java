package net.flixgames.signwarp.utils;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {

    public static String prefix = "§4§lSignWarp §7| ";
    public static String noperms = prefix + "§cDazu hast du keine Rechte!";

    public static HashMap<String, Location> warps = new HashMap<>();

    public static List<String> getWarps() {
        List<String> list;
        if(FileManager.cfg.get("Warps") != null) {
            return list = FileManager.cfg.getStringList("Warps");
        }
        return list = new ArrayList<>();
    }

}
