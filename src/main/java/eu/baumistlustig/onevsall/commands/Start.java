package eu.baumistlustig.onevsall.commands;

import eu.baumistlustig.onevsall.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class Start implements CommandExecutor {

    public static void openStartmenu(Player p) {
        Inventory inventory = Bukkit.createInventory(null, 9, ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü");

        inventory.setItem(0, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setDisplayname(ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü")
                .setLocalizedName("block")
                .build());

        inventory.setItem(1, new ItemBuilder(Material.CLOCK)
                .setDisplayname(ChatColor.GREEN.toString() + ChatColor.BOLD + "Starte das Spiel")
                .setLore(ChatColor.GRAY + "Das Spiel wird innerhalb von 100 Sekunden gestartet.")
                .setLocalizedName("start")
                .build());

        inventory.setItem(2, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setDisplayname(ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü")
                .setLocalizedName("block")
                .build());

        inventory.setItem(3, new ItemBuilder(Material.BARRIER)
                .setDisplayname(ChatColor.RED.toString() + ChatColor.BOLD + "Reset der Welt")
                .setLore(ChatColor.GRAY + "Die Welt wird zurückgesetzt.")
                .setLocalizedName("reset")
                .build());

        inventory.setItem(4, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setDisplayname(ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü")
                .setLocalizedName("block")
                .build());

        inventory.setItem(5, new ItemBuilder(Material.EMERALD_BLOCK)
                .setDisplayname(ChatColor.AQUA.toString() + ChatColor.BOLD + "InstaStart der Runde")
                .setLore(ChatColor.GRAY + "Die Runde wird soft gestartet, es gibt keinen Timer.")
                .setLocalizedName("instastart")
                .build());

        inventory.setItem(6, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setDisplayname(ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü")
                .setLocalizedName("block")
                .build());

        inventory.setItem(8, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                .setDisplayname(ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü")
                .setLocalizedName("block")
                .build());

        p.openInventory(inventory);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label, String[] args) {

        Player p = (Player) s;

        openStartmenu(p);

        return false;
    }
}
