package ru.redguy.redevent.events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public interface Event extends Listener {
    String getEventName();

    String getEventShortDescription();
    String getEventFullDescription();

    GameMode getGameMode();

    void Init();
    void registerTimers();
    void stop();
    void unRegisterTimers();

    @EventHandler(priority = EventPriority.HIGH)
    void onDeath(EntityDamageEvent event);
    @EventHandler(priority = EventPriority.HIGH)
    void onDisconnect(PlayerQuitEvent event);
    @EventHandler(priority = EventPriority.HIGH)
    void onDamaged(EntityDamageEvent event);
    @EventHandler(priority = EventPriority.HIGH)
    void onMoved(PlayerMoveEvent event);
    @EventHandler(priority = EventPriority.HIGH)
    void onBlockBreak(BlockBreakEvent event);
}
