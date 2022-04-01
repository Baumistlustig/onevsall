package eu.baumistlustig.onevsall.commands;

import eu.baumistlustig.onevsall.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class getStartMenu implements CommandExecutor {

    public void giveStartMenuItem(Player p) {
        if ((p.isOp() || p.hasPermission("*")) && !(p.getInventory().contains(Material.CLOCK))) {
            p.getInventory().addItem(new ItemBuilder(Material.CLOCK)
                    .setDisplayname(ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü")
                    .setLore(ChatColor.GRAY + "Öffnet das Startmenü zum Starten und Verwalten der Runde.")
                    .setLocalizedName("startmenu")
                    .build());
        }
    }
    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command smd, @NotNull String label, @NotNull String[] args) {
        giveStartMenuItem((Player) s);
        return false;
    }
}
