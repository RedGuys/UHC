package ru.redguy.reduhc.commands;

import org.bukkit.command.PluginCommand;
import ru.redguy.reduhc.RedUHC;

public class CommandsRegister {
    public static void register() {
        PluginCommand command = RedUHC.getInstance().getServer().getPluginCommand("uhc");
        command.setExecutor(new UHC());
        command.setTabCompleter(new AutoComplete());
    }
}
