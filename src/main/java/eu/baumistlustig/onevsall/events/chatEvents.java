package eu.baumistlustig.onevsall.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatEvents implements Listener {

    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (p.isOp() || p.hasPermission("*")) {
            e.setFormat(ChatColor.RED + "Admin" + ChatColor.GRAY + " ┃ " + p.getName() + " » " + ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        } else {
            e.setFormat(ChatColor.GREEN + "Spieler" + ChatColor.GRAY + " ┃ " + p.getName() + " » " + e.getMessage());
        }
    }
}
