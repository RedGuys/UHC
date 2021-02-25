package ru.redguy.redevent.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import ru.redguy.redevent.RedEvent;
import ru.redguy.redevent.utils.ChatUtils;
import ru.redguy.redevent.utils.RunnablePresets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositionSwapEvent implements Event {

    List<Integer> tasks = new ArrayList<>();

    @Override
    public String getEventName() {
        return "Смена позиций";
    }

    @Override
    public String getEventShortDescription() {
        return "Заставит вас поменяться местами с другим игроком";
    }

    @Override
    public String getEventFullDescription() {
        return "Каждые 5 минут игроки будут менятся позициями";
    }

    @Override
    public GameMode getGameMode() {
        return GameMode.SURVIVAL;
    }

    @Override
    public void Init() {

    }

    @Override
    public void registerTimers() {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.INSTANCE, new RunnablePresets.Timer("смены позициями",270),600,6000));
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.INSTANCE, new PositionSwap(),6000,6000));
    }

    @Override
    public void stop() {

    }

    @Override
    public void unRegisterTimers() {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        for (Integer task : tasks) {
            scheduler.cancelTask(task);
        }
    }

    @Override
    public void onDeath(EntityDamageEvent event) {

    }

    @Override
    public void onDisconnect(PlayerQuitEvent event) {

    }

    @Override
    public void onDamaged(EntityDamageEvent event) {

    }

    @Override
    public void onMoved(PlayerMoveEvent event) {

    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {

    }

    private static class PositionSwap implements Runnable {

        @Override
        public void run() {
            List<Player> players = RedEvent.getGame().getPlayers();
            List<Location> positions = new ArrayList<>();
            for (Player player : players) {
                positions.add(player.getLocation());
            }
            Collections.shuffle(positions);
            for (int i = 0; i < players.size(); i++) {
                Location location = players.get(i).getLocation();
                location.setX(positions.get(i).getX());
                location.setY(positions.get(i).getY());
                location.setZ(positions.get(i).getZ());
            }
            ChatUtils.sendToAll("Обмен позициями!");
        }
    }
}
