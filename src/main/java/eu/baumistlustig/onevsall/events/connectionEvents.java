package eu.baumistlustig.onevsall.events;

import eu.baumistlustig.onevsall.OnevsAll;
import eu.baumistlustig.onevsall.commands.getStartMenu;
import eu.baumistlustig.onevsall.utils.Scoreboard;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class connectionEvents implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        // Set Welcome Message
        e.joinMessage(Component.text(ChatColor.BOLD.toString() + ChatColor.GREEN  + "+ " + ChatColor.RESET+ ChatColor.GRAY + p.getName()));

        // Give Administrators an Item to open the start menu
        getStartMenu startMenu = OnevsAll.getInstance().getStartMenuItem();
        startMenu.giveStartMenuItem(p);

        // Load Scoreboard
        p.setScoreboard(Scoreboard.getBaseScoreboard(p));
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        //Set Leave Message
        e.quitMessage(Component.text(ChatColor.BOLD.toString() + ChatColor.RED + "- " + ChatColor.RESET + ChatColor.GRAY + p.getName()));
    }
}
