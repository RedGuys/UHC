package ru.redguy.redevent.utils;

import org.bukkit.entity.Player;

import java.util.List;

public class ChatUtils {
    public static void sendMessages(Player player, List<String> messages) {
        for (String message : messages) {
            player.sendMessage(message);
        }
    }
}
