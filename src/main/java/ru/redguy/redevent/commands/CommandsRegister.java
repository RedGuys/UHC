package ru.redguy.redevent.commands;

import ru.redguy.redevent.RedEvent;

import java.util.Objects;

public class CommandsRegister {
    public static void register() {
        Objects.requireNonNull(RedEvent.INSTANCE.getServer().getPluginCommand("event")).setExecutor(new Event());
    }
}
