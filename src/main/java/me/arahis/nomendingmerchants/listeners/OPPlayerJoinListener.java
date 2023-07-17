package me.arahis.nomendingmerchants.listeners;

import me.arahis.nomendingmerchants.NoMendingMerchants;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;

public class OPPlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(event.getPlayer().isOp()) {
            if(Arrays.stream(VillagerAcquireTradeEvent.getHandlerList().getRegisteredListeners()).anyMatch(registeredListener -> registeredListener.getPlugin().equals(NoMendingMerchants.getPlugin()))) {
                event.getPlayer().sendMessage("Починка у жителей не может появится в этом мире");
                event.getPlayer().sendMessage("/mending on - если хотите включить");
            } else {
                event.getPlayer().sendMessage("Починки у жителей может появится в этом мире");
                event.getPlayer().sendMessage("/mending off - если хотите выключить");
            }
        }
    }
}
