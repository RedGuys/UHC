package ru.redguy.reduhc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.redguy.reduhc.commands.CommandsRegister;
import ru.redguy.reduhc.utils.discord.HooksEvents;

public final class RedUHC extends JavaPlugin {

    private static RedUHC Instance;
    private Game game;

    @Override
    public void onEnable() {
        Instance = this;
        Config.Load();
        Config.Save();
        Messages.Load();

        CommandsRegister.register();
        Bukkit.getPluginManager().registerEvents(new HooksEvents(),this);

        game = new Game();
        Bukkit.getPluginManager().registerEvents(game, this);
    }

    @Override
    public void onDisable() {
        Config.Save();
    }

    public static Game getGame() {
        return getInstance().game;
    }

    public static RedUHC getInstance() {
        return Instance;
    }
}
