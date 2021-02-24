package ru.redguy.redevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.redguy.redevent.events.Event;
import ru.redguy.redevent.utils.ChatUtils;
import ru.redguy.redevent.utils.ListUtils;
import ru.redguy.redevent.utils.TeleportUtils;
import ru.redguy.redevent.utils.discord.HooksActions;

import java.util.*;

public class Game implements Listener {

    public GameState gameState = GameState.wait;
    private List<Event> scenarios = new ArrayList<>();
    Map<String, Integer> kills = new HashMap<>();
    ArrayList<Player> players = new ArrayList<>();

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
    public void onDeath(EntityDamageEvent event) {
        if(!event.isCancelled()) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if (RedEvent.getGame().isPlayerInGame(player)) {
                    if ((player.getHealth() - event.getDamage()) <= 0) {
                        for (Event scenario : scenarios) {
                            scenario.onDeath(event);
                        }
                        handlePlayerLost(player);
                    }
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

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {

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
}
