package ru.redguy.redevent.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ru.redguy.redevent.utils.PlayersUtils;

public class SuperHeros implements Event {
    @Override
    public String getEventName() {
        return "Супер герои";
    }

    @Override
    public String getEventShortDescription() {
        return "Выдаст всем игрокам сильные эффекты";
    }

    @Override
    public String getEventFullDescription() {
        return "При начале игры выдаст сильные эффекты";
    }

    @Override
    public GameMode getGameMode() {
        return GameMode.SURVIVAL;
    }

    @Override
    public void Init() {
        PlayersUtils.forAllAlivePlayers((player -> {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,999999,25));
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,999999,25));
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,999999,25));
        }));
    }

    @Override
    public void registerTimers() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void unRegisterTimers() {

    }

    @Override
    public void addTimerId(int id) {

    }

    @Override
    public void onDeath(PlayerDeathEvent event) {

    }

    @Override
    public void onDisconnect(PlayerQuitEvent event) {

    }

    @Override
    public void onDamage(EntityDamageEvent event, Player player) {

    }

    @Override
    public void onMoved(PlayerMoveEvent event) {

    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {

    }
}
