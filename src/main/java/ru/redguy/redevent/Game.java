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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements Listener {

    public GameState gameState = GameState.wait;
    private List<Event> scenarios = new ArrayList<>();
    Map<String, Integer> kills = new HashMap<>();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Player> rejoinablePlayers = new ArrayList<>();

    public Game() {

    }

    public void start() {
        players.addAll(Bukkit.getOnlinePlayers());
        rejoinablePlayers.addAll(players);
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

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDisconnect(PlayerQuitEvent event) {

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onMoved(PlayerMoveEvent event) {

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {

    }
}
