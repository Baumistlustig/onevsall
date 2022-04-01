package eu.baumistlustig.onevsall.utils;

import eu.baumistlustig.onevsall.OnevsAll;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Round {

    private boolean gameRunning;
    private int gameTime;

    public Round (boolean gameRunning, int gameTime) {
        this.gameRunning = gameRunning;
        this.gameTime = gameTime;
        run();
    }

    public boolean gameIsRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean running) {
        this.gameRunning = running;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int time) {
        this.gameTime = time;
    }

    public void startedGame(Player p) {
        p.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Let's Go!", ChatColor.GRAY + "Alle gegen einen ist eröffnet.");
    }

    public void sendActionBar() {
        for (Player p : Bukkit.getOnlinePlayers()) {

            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD + "Runde läuft seit:"
                    + ChatColor.BOLD + getGameTime()
                    + ChatColor.RESET + ChatColor.RED + " ┃ "
                    + ChatColor.GOLD + ChatColor.BOLD + "Es leben noch x Spieler"
            ));
        }
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if (!gameIsRunning()) {
                    return;
                }

                setGameTime(getGameTime() + 1);
            }
        }.runTaskTimer(OnevsAll.getInstance(), 20, 20);
    }
}
