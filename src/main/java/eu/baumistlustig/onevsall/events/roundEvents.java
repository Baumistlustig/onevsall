package eu.baumistlustig.onevsall.events;

import eu.baumistlustig.onevsall.OnevsAll;
import eu.baumistlustig.onevsall.utils.Round;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class roundEvents implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();

        p.setGameMode(GameMode.SPECTATOR);

        Round round = OnevsAll.getInstance().getRound();

        round.checkForWin(p);
    }
}
