package ru.redguy.redevent;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

    public GameState gameState = GameState.wait;
    //private List<Event> scenarios;
    Map<String, Integer> kills;
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Player> rejoinablePlayers = new ArrayList<>();

    public Game() {
        //scenarios = new ArrayList<>();
        kills = new HashMap<>();
    }

    public boolean isPlayerInGame(Player player) {
        return players.contains(player);
    }

    public int getPlayerKills(Player player) {
        return kills.getOrDefault(player.getName(),0);
    }
}
