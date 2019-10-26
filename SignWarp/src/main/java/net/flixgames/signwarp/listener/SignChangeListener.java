package net.flixgames.signwarp.listener;

import net.flixgames.signwarp.SignWarp;
import net.flixgames.signwarp.utils.Data;
import net.flixgames.signwarp.utils.FileManager;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignChangeListener implements Listener {

    public SignChangeListener(SignWarp main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        Player player = event.getPlayer();
        if(event.getLine(0).equalsIgnoreCase("[warp]")) {
            if(player.hasPermission("signwarp.createsign")) {
                String warp = null;
                if(!event.getLine(1).equals("")) {
                    warp = event.getLine(1);
                    if(FileManager.cfg.contains(warp)) {
                        event.setLine(0, "§1[ | Warp | ]");
                        event.setLine(1, "§6" + warp);
                        event.setLine(2, "§7| Rechtsklick |");
                        player.sendMessage(Data.prefix + "§aDu hast ein neues Warp-Schild erstellt");
                    } else {
                        event.setLine(0, "§1[ | Warp | ]");
                        event.setLine(1, "§cDieser Warp");
                        event.setLine(2, "§cexistiert nicht");
                    }
                } else {
                    event.setLine(0, "§1[ | Warp | ]");
                    event.setLine(1, "§cBitte gebe");
                    event.setLine(2, "§ceinen Warp an");
                }
            }
        }
    }

}
