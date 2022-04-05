package eu.baumistlustig.onevsall.commands;

import eu.baumistlustig.onevsall.OnevsAll;
import eu.baumistlustig.onevsall.utils.Round;
import eu.baumistlustig.onevsall.utils.Timer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RoundCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) s;

        Timer timer = OnevsAll.getInstance().getTimer();
        Round round = OnevsAll.getInstance().getRound();

        switch (args[0].toLowerCase()) {
            case "instastart": {

                if (round.gameIsRunning() || timer.timerIsRunning()) {
                    break;
                }

                p.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Let's Go!",
                        ChatColor.GRAY + "Alle gegen einen ist eröffnet."
                );

                round.setGameRunning(true);
                break;
            }

            case "stop": {

                if (!round.gameIsRunning()) {
                    break;
                }

                round.setGameRunning(false);
            }
        }

        return false;
    }
}
