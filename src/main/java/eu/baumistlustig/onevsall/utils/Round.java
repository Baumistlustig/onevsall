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

    public void sendActionBar() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (!gameIsRunning()) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED.toString() + ChatColor.ITALIC + ""));
                continue;
            }

            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + getGameTime()));
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
