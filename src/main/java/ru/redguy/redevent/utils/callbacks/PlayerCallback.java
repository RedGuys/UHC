package ru.redguy.redevent.utils.callbacks;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface PlayerCallback {
    public void work(Player player);
}
