package ru.redguy.redevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitTask;
import ru.redguy.redevent.events.DragonEscape;
import ru.redguy.redevent.events.Event;
import ru.redguy.redevent.utils.*;
import ru.redguy.redevent.utils.discord.HooksActions;

import java.util.*;

public class Game implements Listener {

    public GameState gameState = GameState.wait;
    private List<Event> scenarios = new ArrayList<>();
    Map<String, Integer> kills = new HashMap<>();
    ArrayList<Player> players = new ArrayList<>();
    private int borderSize;
    private int borderTask;

    public Game() {

    }

    public void start() {
        players.addAll(Bukkit.getOnlinePlayers());
        StringBuilder scenarioString = new StringBuilder();
        for (Event scenario : scenarios) {
            scenarioString.append(scenario.getEventName()).append(" ,");
            scenario.registerTimers();
            scenario.Init();
        }
        gameState = GameState.game;
        PlayersUtils.teleportAllPlayers(TeleportUtils.getSafeLocation(0,0));
        PlayersUtils.clearAllEffects();
        PlayersUtils.clearInventoriesAll();
        PlayersUtils.feedAllPlayers();
        PlayersUtils.regenAllPlayers();
        WorldsUtils.getDefaultWorld().getWorldBorder().setSize(2000);
        borderSize = 2000;
        WorldsUtils.getDefaultWorld().getWorldBorder().setCenter(0,0);
        borderTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(RedEvent.INSTANCE, new BorderWorker(),12000,12000);
        ChatUtils.sendToAll("Игра началась!");
        ChatUtils.sendToAll("Активные модификаторы: "+scenarioString.substring(0,scenarioString.length()-1));
    }

    public boolean isPlayerInGame(Player player) {
        return players.contains(player);
    }

    public int getPlayerKills(Player player) {
        return kills.getOrDefault(player.getName(),0);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addScenarios(Event event) {
        if(gameState == GameState.wait) {
            if(!ListUtils.isScenariosAdded(scenarios,event)) {
                scenarios.add(event);
            }
        }
    }

    public int getScenariosCount() {
        return scenarios.size();
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDeath(EntityDeathEvent eve) {
        if (eve instanceof PlayerDeathEvent) {
            PlayerDeathEvent event = (PlayerDeathEvent) eve;
            Player dead = event.getEntity();
            Player killer = dead.getKiller();
            if (RedEvent.getGame().isPlayerInGame(dead)) {
                for (Event scenario : scenarios) {
                    scenario.onDeath(event);
                }
                handlePlayerLost(dead);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDamage(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if(RedEvent.getGame().isPlayerInGame(player)) {
                for (Event scenario : scenarios) {
                    scenario.onDamage(event, player);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDisconnect(PlayerQuitEvent event) {
        handlePlayerLost(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onMoved(PlayerMoveEvent event) {
        if(isPlayerInGame(event.getPlayer())) {
            for (Event scenario : scenarios) {
                scenario.onMoved(event);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        if(isPlayerInGame(event.getPlayer())) {
            for (Event scenario : scenarios) {
                scenario.onBlockBreak(event);
            }
        }
    }

    private void handlePlayerLost(Player player) {
        players.remove(player);
        if(players.size() < 2) {
            Optional<Player> optionalWinner = players.stream().findAny();
            Player winner;
            if(optionalWinner.isPresent()) {
                winner = players.stream().findAny().get();
            } else {
                winner = player;
            }
            ChatUtils.sendToAll(winner.getName()+" победил!");
            workStop();
        }
    }

    private void workStop() {
        for (Event scenario : scenarios) {
            scenario.unRegisterTimers();
            scenario.stop();
        }
        players.clear();
        kills.clear();
        scenarios.clear();
        gameState = GameState.wait;
    }

    class BorderWorker implements Runnable {

        @Override
        public void run() {
            int resizeTime = 0;
            switch (borderSize) {
                case 2000:
                    borderSize = 1000;
                    resizeTime = 6000;
                    break;
                case 1000:
                    borderSize = 500;
                    resizeTime = 3000;
                    break;
                case 500:
                    borderSize = 250;
                    resizeTime = 1500;
                    break;
                case 250:
                    borderSize = 25;
                    resizeTime = 150;
                    break;
                case 25:
                    Bukkit.getScheduler().cancelTask(borderTask);
                    return;
            }

            WorldsUtils.getDefaultWorld().getWorldBorder().setSize(borderSize,resizeTime);
        }
    }
}
