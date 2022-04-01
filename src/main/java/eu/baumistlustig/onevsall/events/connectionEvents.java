package eu.baumistlustig.onevsall.events;

import eu.baumistlustig.onevsall.utils.ItemBuilder;
import eu.baumistlustig.onevsall.utils.Scoreboard;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class connectionEvents implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        // Give Administrators an Item to open the startmenu.

        if ((p.isOp() || p.hasPermission("*")) && !(p.getInventory().contains(Material.CLOCK))) {
            p.getInventory().addItem(new ItemBuilder(Material.CLOCK)
                    .setDisplayname(ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü")
                    .setLore(ChatColor.GRAY + "Öffnet das Startmenü zum Starten und Verwalten der Runde.")
                    .setLocalizedName("startmenu")
                    .build());
        }

        // Set Welcome Message
        e.joinMessage(Component.text(ChatColor.BOLD.toString() + ChatColor.GREEN  + "+ " + ChatColor.RESET+ ChatColor.GRAY + p.getName()));

        // Load Scoreboard
        p.setScoreboard(Scoreboard.getBaseScoreboard(e.getPlayer()));
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        //Set Leave Message
        e.quitMessage(Component.text(ChatColor.BOLD.toString() + ChatColor.RED + "- " + ChatColor.RESET + ChatColor.GRAY + p.getName()));
    }
}
