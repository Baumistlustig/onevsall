package eu.baumistlustig.onevsall.events;

import eu.baumistlustig.onevsall.commands.Start;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemClickEvent implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getItem() == null) return;

        ItemStack itemstack = e.getItem();

        if (itemstack.getItemMeta().getLocalizedName().equals("startmenu")) {
            Start.openStartmenu(p);
        }
    }
}
