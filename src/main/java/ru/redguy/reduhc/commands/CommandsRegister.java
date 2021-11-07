package ru.redguy.reduhc.commands;

import org.bukkit.command.PluginCommand;
import ru.redguy.reduhc.RedUHC;

public class CommandsRegister {
    public static void register() {
        PluginCommand command = RedUHC.Instance.getServer().getPluginCommand("event");
        command.setExecutor(new Event());
        command.setTabCompleter(new AutoComplete());
    }
}
