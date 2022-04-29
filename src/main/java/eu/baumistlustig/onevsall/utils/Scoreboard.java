package eu.baumistlustig.onevsall.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.Objects;

public class Scoreboard {
    public static org.bukkit.scoreboard.Scoreboard getBaseScoreboard(Player p) {
        org.bukkit.scoreboard.Scoreboard s = Objects.requireNonNull(Bukkit.getScoreboardManager().getNewScoreboard());
        int OnlineMembers = Bukkit.getServer().getOnlinePlayers().toArray().length;
        Objective objective = s.registerNewObjective(ChatColor.AQUA + "" + ChatColor.BOLD + "OneVsAll", ChatColor.GREEN + "www.baumistlustig.eu » Test");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore(ChatColor.GREEN + "§n OneVsAll » Started/Not started yet").setScore(0);
        objective.getScore(ChatColor.DARK_GRAY + "-------------").setScore(1);
        objective.getScore("§1").setScore(2);
        objective.getScore(ChatColor.GRAY + "» " + ChatColor.AQUA + "" + OnlineMembers + ChatColor.GRAY + "/100").setScore(3);
        objective.getScore(ChatColor.GREEN + "Spieler").setScore(4);

        return s;
    }
}
