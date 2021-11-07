package ru.redguy.reduhc.utils.discord;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import ru.redguy.reduhc.RedUHC;

public class HooksEvents implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onDeath(EntityDamageEvent event) {
        if(!event.isCancelled()) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if (RedUHC.getGame().isPlayerInGame(player)) {
                    if ((player.getHealth() - event.getDamage()) <= 0) {
                        HooksActions.OnDeath(player);
                    }
                }
            }
        }
    }
}
