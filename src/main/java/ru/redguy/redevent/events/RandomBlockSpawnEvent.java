package ru.redguy.redevent.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;
import ru.redguy.redevent.RedEvent;
import ru.redguy.redevent.utils.ChatUtils;
import ru.redguy.redevent.utils.RunnablePresets;
import ru.redguy.redevent.utils.WhiteLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBlockSpawnEvent implements Event {

    List<Integer> tasks = new ArrayList<>();

    @Override
    public String getEventName() {
        return "Спавн случайного блока";
    }

    @Override
    public String getEventShortDescription() {
        return "Будет спавнить случайный блок под вами каждую минуту";
    }

    @Override
    public String getEventFullDescription() {
        return "Каждую минуту под вами будет спавниться случайный блок.";
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
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.INSTANCE, new RunnablePresets.Timer("спавна блока",60),0,1200));
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.INSTANCE, new BlockSpawner(),1200,1200));
    }

    @Override
    public void stop() {

    }

    @Override
    public void unRegisterTimers() {

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

    class BlockSpawner implements Runnable {

        @Override
        public void run() {
            for (Player player : RedEvent.getGame().getPlayers()) {
                Material blockType = WhiteLists.blockSpawn[new Random().nextInt(WhiteLists.blockSpawn.length)];
                Location location = player.getLocation();
                location.subtract(0,1,0).getBlock().setType(blockType);
            }
            ChatUtils.sendToAll("Спавн блоков!");
        }
    }
}
