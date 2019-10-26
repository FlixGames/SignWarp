package net.flixgames.signwarp.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static File file = new File("plugins//SignWarp//warps.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void save() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
