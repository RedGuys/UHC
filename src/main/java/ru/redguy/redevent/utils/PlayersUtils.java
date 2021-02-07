package ru.redguy.redevent.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import ru.redguy.redevent.utils.callbacks.PlayerCallback;

import java.util.ArrayList;
import java.util.Collections;

public class PlayersUtils {
    public static void setGameModeToAll(GameMode gameMode) {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            onlinePlayer.setGameMode(gameMode);
        }
    }

    public static void teleportAllPlayers(Location location) {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            onlinePlayer.teleport(location);
        }
    }

    public static void clearInventoriesAll() {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            onlinePlayer.getInventory().clear();
        }
    }

    public static void regenAllPlayers() {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            onlinePlayer.setHealth(20.0);
        }
    }

    public static void feedAllPlayers() {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            onlinePlayer.setFoodLevel(20);
        }
    }

    public static void damageAllPlayers(double damage) {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            onlinePlayer.damage(damage);
        }
    }

    public static void damagePlayer(Player player, double damage) {
        player.damage(damage);
    }

    public static void forAllAlivePlayers(PlayerCallback worker) {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            if(onlinePlayer.getGameMode().equals(GameMode.SURVIVAL)) {
                worker.work(onlinePlayer);
            }
        }
    }

    public static void clearEffects(Player player) {
        player.getEffectivePermissions().clear();
    }

    public static void clearAllEffects() {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            clearEffects(onlinePlayer);
        }
    }

    public static void giveItemsToAllAlive(ItemStack itemType) {
        forAllAlivePlayers(player -> {
            Inventory inventory = player.getInventory();
            inventory.addItem(itemType);
        });
    }

    public static ArrayList<Player> getAllAlivePlayers() {
        ArrayList<Player> players = new ArrayList<>();
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            if(onlinePlayer.getGameMode().equals(GameMode.SURVIVAL)) {
                players.add(onlinePlayer);
            }
        }
        return players;
    }

    public static ArrayList<Player> getAllPlayers() {
        return new ArrayList<>(Bukkit.getServer().getOnlinePlayers());
    }

    public static Player getRandomAlivePlayer() {
        ArrayList<Player> players = getAllAlivePlayers();
        Collections.shuffle(players);
        return players.get(0);
    }

    public static boolean isPlayerAlive(Player player) {
        return player.getGameMode().equals(GameMode.SURVIVAL);
    }

    public static String getAllAlivePlayersString() {
        StringBuilder stringBuilder = new StringBuilder();
        forAllAlivePlayers(player -> {
            stringBuilder.append(player.getName()).append(" ");
        });
        return stringBuilder.toString();
    }
}