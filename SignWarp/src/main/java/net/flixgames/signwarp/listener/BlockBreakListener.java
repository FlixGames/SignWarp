package net.flixgames.signwarp.listener;

import net.flixgames.signwarp.SignWarp;
import net.flixgames.signwarp.utils.Data;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    public BlockBreakListener(SignWarp main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(event.getBlock().getType().equals(Material.SIGN_POST) || event.getBlock().getType().equals(Material.WALL_SIGN)) {
            Sign sign = (Sign) event.getBlock().getState();
            if(sign.getLine(0).equals("§1[ | Warp | ]")) {
                if(player.hasPermission("signwarp.breaksign")) {
                    if(!player.isSneaking()) {
                        event.setCancelled(true);
                        player.sendMessage(Data.prefix + "§cBitte halte Sneak gedrückt, um ein Warp-Schild abzubauen");
                    }
                } else {
                    player.sendMessage(Data.noperms);
                }
            }
        }
    }

}
