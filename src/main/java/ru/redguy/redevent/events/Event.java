package ru.redguy.redevent.events;

import org.bukkit.GameMode;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public interface Event {
    String getEventName();

    String getEventShortDescription();
    String getEventFullDescription();

    GameMode getGameMode();

    void Init();
    void registerTimers();
    void stop();
    void unRegisterTimers();

    void onDeath(EntityDamageEvent event);
    void onDisconnect(PlayerQuitEvent event);
    void onDamaged(EntityDamageEvent event);
    void onMoved(PlayerMoveEvent event);
    void onBlockBreak(BlockBreakEvent event);
}
