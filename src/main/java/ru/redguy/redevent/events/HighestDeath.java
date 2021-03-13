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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HighestDeath implements Event {

    List<Integer> tasks = new ArrayList<>();

    @Override
    public String getEventName() {
        return "Высотная смерть";
    }

    @Override
    public String getEventShortDescription() {
        return "Будет каджую минуту убивать самого высокого игрока";
    }

    @Override
    public String getEventFullDescription() {
        return "Каждую минуту игрок находящийся на большей высоте, умирает";
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
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.INSTANCE, new RunnablePresets.Timer("смерти игрока",60),0,1200));
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.INSTANCE, new Killer(),1200,1200));
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

    static class Killer implements Runnable {
        @Override
        public void run() {
            List<Player> players = PlayersUtils.getAllPlayers();
            players.sort(Comparator.comparingDouble(o -> o.getLocation().getY()));
            Player killed = players.get(0);
            killed.damage(killed.getHealth()+1);
            ChatUtils.sendToAll(killed.getName()+" был убит! y="+killed.getLocation().getY());
        }
    }
}