package ru.redguy.redevent.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
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

public class InventorySwapEvent implements Event {

    List<Integer> tasks = new ArrayList<>();

    @Override
    public String getEventName() {
        return "Обмен инвентарями";
    }

    @Override
    public String getEventShortDescription() {
        return "Заставит вас обменятся вещами с другими игроками.";
    }

    @Override
    public String getEventFullDescription() {
        return "Каждые 5 минут игроки будут менятся своими инвентарями.";
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
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.INSTANCE, new RunnablePresets.Timer("смены инвентарей",270),600,6000));
        tasks.add(scheduler.scheduleSyncRepeatingTask(RedEvent.INSTANCE, new InventorySwap(),6000,6000));
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
    public void onDamage(EntityDamageEvent event, Player player) {

    }

    @Override
    public void onDisconnect(PlayerQuitEvent event) {

    }

    @Override
    public void onMoved(PlayerMoveEvent event) {

    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {

    }

    private static class InventorySwap implements Runnable {

        @Override
        public void run() {
            List<Player> players = RedEvent.getGame().getPlayers();
            List<ItemStack[]> inventories = new ArrayList<>();
            for (Player player : players) {
                inventories.add(player.getInventory().getContents());
                player.getInventory().clear();
            }
            Collections.shuffle(inventories);
            for (int i = 0; i < players.size(); i++) {
                players.get(i).getInventory().setContents(inventories.get(i));
            }
            ChatUtils.sendToAll("Обмен инвентарями!");
        }
    }
}
