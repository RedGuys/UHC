package ru.redguy.reduhc.chat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.redguy.reduhc.utils.ChatUtils;
import ru.redguy.reduhc.utils.TextUtils;

public class ChatEvents implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent) {
        ChatUtils.sendMessages(playerJoinEvent.getPlayer(), TextUtils.Join(playerJoinEvent.getPlayer()));
        playerJoinEvent.setJoinMessage("");
    }
}
