package ru.redguy.reduhc;

import okhttp3.OkHttpClient;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.redguy.reduhc.commands.CommandsRegister;
import ru.redguy.reduhc.utils.discord.HooksEvents;

public final class RedUHC extends JavaPlugin {

    public static RedUHC Instance;
    public Game game;
    public OkHttpClient okHttpClient;

    @Override
    public void onEnable() {
        Instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        Config.Load();
        Config.Save();

        okHttpClient = new OkHttpClient();
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
        return Instance.game;
    }
}
