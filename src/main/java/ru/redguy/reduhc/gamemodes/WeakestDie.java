package ru.redguy.reduhc.gamemodes;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.utils.ChatUtils;
import ru.redguy.reduhc.utils.PlayersUtils;
import ru.redguy.reduhc.utils.RunnablePresets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeakestDie implements Event {

    List<Integer> tasks = new ArrayList<>();

    @Override
    public String getEventName() {
        return "Смерть слабейшего";
    }

    @Override
    public String getEventShortDescription() {
        return "Будет убивать игрока с меньшим количеством здоровья.";
    }

    @Override
    public String getEventFullDescription() {
        return "Каждую минуту, игрок с меньшим количеством здоровья, умирает.";
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
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedUHC.getInstance(), new RunnablePresets.Timer("смерти слабейшего",60,this),0,1200));
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedUHC.getInstance(), new Killer(),1200,1200));
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

    static class Killer implements Runnable {
        @Override
        public void run() {
            List<Player> players = PlayersUtils.getAllPlayers();
            players.sort(Comparator.comparingDouble(Damageable::getHealth));
            Player killed = players.get(0);
            double health = killed.getHealth();
            killed.damage(killed.getHealth()+1);
            ChatUtils.sendToAll(killed.getName()+" был убит! HP="+health);
        }
    }
}
