package ru.redguy.redevent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.redguy.redguyapi.event.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game implements Listener {

    public GameState gameState = GameState.wait;
    private List<Event> scenarios;
    Map<String, Integer> kills;
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Player> rejoinablePlayers = new ArrayList<>();

    public Game() {
        scenarios = new ArrayList<>();
        kills = new HashMap<>();
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
