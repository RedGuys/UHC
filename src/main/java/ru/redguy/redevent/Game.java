package ru.redguy.redevent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.redguy.redevent.events.Event;

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
        rejoinablePlayers.addAll(players);
        for (Event scenario : scenarios) {
            scenario.registerTimers();
            scenario.Init();
        }
        gameState = GameState.game;
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
            scenarios.add(event);
        }
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
