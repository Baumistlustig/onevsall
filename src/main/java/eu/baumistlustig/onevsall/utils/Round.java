package eu.baumistlustig.onevsall.utils;

import eu.baumistlustig.onevsall.OnevsAll;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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

    public void checkForWin (Player p ) {
        if (!gameIsRunning()) { return; }
        if (p.isOp()) {
            setGameRunning(false);
            p.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Runde vorbei!",
                    ChatColor.GRAY + "Die Spieler haben den Streamer eliminiert und gewinnt somit!"
            );
        } else {
            boolean counter = true;
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (onlinePlayer.getGameMode().equals(GameMode.SURVIVAL)) {
                    counter = true;
                    break;
                } else {
                    counter = false;
                }
            }

            if (!counter) {
                setGameRunning(false);
                p.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Runde vorbei!",
                        ChatColor.GRAY + "Der Streamer hat alle Gegner eliminiert, und gewinnt somit!"
                );
            }
        }
    }

    public void sendActionBar() {
        int playerCount = 0;
        for (Player p : Bukkit.getOnlinePlayers()) {

            if (!gameIsRunning()) {
                continue;
            }

            if (!(p.isOp()) && p.getGameMode().equals(GameMode.SURVIVAL)) playerCount += 1;

            if (playerCount == 1) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD + "Runde läuft seit: "
                        + ChatColor.BOLD + getGameTime()
                        + ChatColor.RESET + ChatColor.RED + " ┃ "
                        + ChatColor.GOLD + ChatColor.BOLD + "Es lebt noch " + playerCount + " Spieler"
                ));
            }

            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD + "Runde läuft seit: "
                    + ChatColor.BOLD + getGameTime()
                    + ChatColor.RESET + ChatColor.RED + " ┃ "
                    + ChatColor.GOLD + ChatColor.BOLD + "Es leben noch " + playerCount + " Spieler"
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
