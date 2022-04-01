package eu.baumistlustig.onevsall.commands;

import eu.baumistlustig.onevsall.OnevsAll;
import eu.baumistlustig.onevsall.utils.Timer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TimerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 0) {
            sendUsage(sender);
            return true;
        }

        Timer timer = OnevsAll.getInstance().getTimer();

        switch (args[0].toLowerCase()) {
            case "resume": {

                timer.setTimerTime(100);

                if (timer.timerIsRunning()) {
                    sender.sendMessage(ChatColor.RED + "Der Timer läuft bereits.");
                    break;
                }

                timer.setTimerRunning(true);
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde gestartet.");
                break;
            }
            case "pause": {

                if (!timer.timerIsRunning()) {
                    sender.sendMessage(ChatColor.RED + "Der Timer läuft nicht.");
                    break;
                }

                timer.setTimerRunning(true);
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde gestoppt.");
                break;
        }
            case "time":

            case "set": {

                if (args.length != 2) {
                    sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ":" + ChatColor.BLUE + "/timer time <zeit>");
                    return true;
                }

                try {

                    timer.setTimerTime(Integer.parseInt(args[1]));
                    sender.sendMessage(ChatColor.GRAY + "Die Zeit wurde auf " + ChatColor.GREEN + args[1] + ChatColor.RESET + " gesetzt.");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Dein Parameter 2 muss eine Zahl sein.");
                }
                break;
            }

            case "reset": {

                timer.setTimerRunning(false);

                timer.setTimerTime(0);
                sender.sendMessage(ChatColor.GRAY + "Der Timer wurde zurückgesetzt.");
                break;
            }
            default:
                sendUsage(sender);
                break;

        }
        return false;
    }

    public void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE + "/timer resume, /timer pause, /timer time <zeit>, /timer reset");

    }

}
