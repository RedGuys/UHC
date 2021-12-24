package ru.redguy.reduhc.gamemodes;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.*;
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

    void addTimerId(int id);

    void onDeath(PlayerDeathEvent event);
    void onDisconnect(PlayerQuitEvent event);
    void onDamage(EntityDamageEvent event, Player player);
    void onMoved(PlayerMoveEvent event);
    void onBlockBreak(BlockBreakEvent event);
}
