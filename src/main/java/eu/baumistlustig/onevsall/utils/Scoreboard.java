package eu.baumistlustig.onevsall.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class Scoreboard {
    public static org.bukkit.scoreboard.Scoreboard getBaseScoreboard(Player p) {
        org.bukkit.scoreboard.Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        int OnlineMembers = Bukkit.getServer().getOnlinePlayers().toArray().length;
        Objective objective = s.registerNewObjective(ChatColor.AQUA + "" + ChatColor.BOLD + "OneVsAll", ChatColor.GREEN + "www.baumistlustig.eu » Test");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);


        return s;
    }
}
