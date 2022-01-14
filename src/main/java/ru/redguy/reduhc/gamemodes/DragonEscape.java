package ru.redguy.reduhc.gamemodes;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.utils.ChatUtils;
import ru.redguy.reduhc.utils.RunnablePresets;
import ru.redguy.reduhc.utils.TeleportUtils;
import ru.redguy.reduhc.utils.WorldsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DragonEscape implements Event {

    List<Integer> tasks = new ArrayList<>();

    @Override
    public String getEventName() {
        return "Драконий рай";
    }

    @Override
    public String getEventShortDescription() {
        return "Будет спавнить дракона на спавне каждые 10 минут";
    }

    @Override
    public String getEventFullDescription() {
        return "Каждые 10 минут на спавне будет спавнится дракон";
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
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedUHC.getInstance(), new RunnablePresets.Timer("спавна дракона",600,this),0,12000));
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedUHC.getInstance(), new DragonSpawner(),12000,12000));
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
    public void addTimerId(int id) {
        tasks.add(id);
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

    static class DragonSpawner implements Runnable {

        @Override
        public void run() {
            ChatUtils.sendToAll("Спавн дракона!");
            WorldsUtils.spawnDragon(Objects.requireNonNull(TeleportUtils.getSafeLocation(0, 0)));
        }
    }
}
