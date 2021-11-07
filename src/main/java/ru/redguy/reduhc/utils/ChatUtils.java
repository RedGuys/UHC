package ru.redguy.reduhc.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class ChatUtils {
    public static void sendMessages(Player player, List<String> messages) {
        for (String message : messages) {
            player.sendMessage(message);
        }
    }

    public static void sendToAll(String text) {
        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            onlinePlayer.sendMessage(text);
        }
    }
}
