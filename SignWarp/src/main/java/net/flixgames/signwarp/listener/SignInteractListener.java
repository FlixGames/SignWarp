package net.flixgames.signwarp.listener;

import net.flixgames.signwarp.SignWarp;
import net.flixgames.signwarp.utils.Data;
import net.flixgames.signwarp.utils.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignInteractListener implements Listener {

    public SignInteractListener(SignWarp main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getClickedBlock() != null && !event.getClickedBlock().getType().equals(Material.AIR)) {
                if(event.getClickedBlock().getType().equals(Material.SIGN_POST) || event.getClickedBlock().getType().equals(Material.WALL_SIGN)) {
                    Sign sign = (Sign) event.getClickedBlock().getState();
                    if(sign.getLine(0).equals("§1[ | Warp | ]")) {
                        String warp = ChatColor.stripColor(sign.getLine(1));
                        if(Data.warps.containsKey(warp)) {
                            player.teleport(Data.warps.get(warp));
                        } else {
                            player.sendMessage(Data.prefix + "§cDieser Warp wurde gelöscht");
                        }
                    }
                }
            }
        }
    }

}
