package ru.redguy.redevent.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;
import ru.redguy.redevent.RedEvent;
import ru.redguy.redevent.utils.ChatUtils;
import ru.redguy.redevent.utils.PlayersUtils;
import ru.redguy.redevent.utils.RunnablePresets;
import ru.redguy.redevent.utils.WorldsUtils;

import java.util.ArrayList;
import java.util.List;

public class DoggyTime implements Event {

    List<Integer> tasks = new ArrayList<>();

    @Override
    public String getEventName() {
        return "Собачьи бои";
    }

    @Override
    public String getEventShortDescription() {
        return "Будет спавнить прирученных собак";
    }

    @Override
    public String getEventFullDescription() {
        return "Каждую минуту у игрока будет спавнится прирученная собака";
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
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.Instance, new RunnablePresets.Timer("спавна собаки",60,this),0,1200));
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.Instance, new Worker(),1200,1200));
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

    static class Worker implements Runnable {

        @Override
        public void run() {
            ChatUtils.sendToAll("Спавн Собачек!");
            PlayersUtils.forAllAlivePlayers(WorldsUtils::spawnDog);
        }
    }
}
