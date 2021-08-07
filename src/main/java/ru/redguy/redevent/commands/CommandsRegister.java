package ru.redguy.redevent.commands;

import org.bukkit.command.PluginCommand;
import ru.redguy.redevent.RedEvent;

public class CommandsRegister {
    public static void register() {
        PluginCommand command = RedEvent.Instance.getServer().getPluginCommand("event");
        command.setExecutor(new Event());
        command.setTabCompleter(new AutoComplete());
    }
}
