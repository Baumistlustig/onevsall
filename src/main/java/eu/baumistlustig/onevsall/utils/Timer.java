package eu.baumistlustig.onevsall.utils;

import eu.baumistlustig.onevsall.OnevsAll;
import net.kyori.adventure.audience.Audience;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private boolean timerRunning;
    private int timerTime = 100;

    public Timer(boolean running, int time) {
        this.timerRunning = running;
        this.timerTime = time;
        run();
    }

    public boolean timerIsRunning() {
        return timerRunning;
    }

    public void setTimerRunning(boolean running) {
        this.timerRunning = running;
    }

    public int getTimerTime() {
        return timerTime;
    }

    public void setTimerTime(int time) {
        this.timerTime = time;
    }

    public void sendActionBar() {
        for (Player p : Bukkit.getOnlinePlayers()) {

            if (!timerIsRunning()) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED.toString() + ChatColor.ITALIC + "Spiel hat noch nicht gestartet."));
                continue;
            }
            p.sendActionBar(new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + getTimerTime()));

            if (getTimerTime() <= 5) {
                switch (getTimerTime()) {
                    case 5:
                        p.sendTitle(ChatColor.RED.toString() + ChatColor.BOLD + "5", ChatColor.GRAY + "Sekunden bis zum Start");
                        break;
                    case 4:
                        p.sendTitle(ChatColor.BLUE.toString() + ChatColor.BOLD + "4", ChatColor.GRAY + "Sekunden bis zum Start");
                        break;
                    case 3:
                        p.sendTitle(ChatColor.YELLOW.toString() + ChatColor.BOLD + "3", ChatColor.GRAY + "Sekunden bis zum Start");
                        break;
                    case 2:
                        p.sendTitle(ChatColor.AQUA.toString() + ChatColor.BOLD + "2", ChatColor.GRAY + "Sekunden bis zum Start");
                        break;
                    case 1:
                        p.sendTitle(ChatColor.GOLD.toString() + ChatColor.BOLD + "1", ChatColor.GRAY + "Sekunden bis zum Start");
                        break;
                    case 0:

                        setTimerRunning(false);

                        p.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Let's Go!", ChatColor.GRAY + "Alle gegen einen ist eröffnet.");

                        p.sendMessage("Debug!!!!");

                        Round round = OnevsAll.getInstance().getRound();

                        round.setGameRunning(true);
                        break;
                }
            }
            p.sendActionBar(new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + getTimerTime()));
            p.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + getTimerTime()));
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + getTimerTime()));
            p.sendActionBar("Test");
            p.sendActionBar(new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + getTimerTime()));
        }
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if (!timerIsRunning()) {
                    return;
                }

                setTimerTime(getTimerTime() - 1);
            }
        }.runTaskTimer(OnevsAll.getInstance(), 20, 20);
    }
}
