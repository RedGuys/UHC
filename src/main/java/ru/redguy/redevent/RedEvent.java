package ru.redguy.redevent;

import okhttp3.OkHttpClient;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.redguy.redevent.commands.CommandsRegister;
import ru.redguy.redevent.utils.discord.HooksEvents;
import ru.redguy.redguyapi.RedGuyApi;

public final class RedEvent extends JavaPlugin {

    public static RedEvent Instance;
    public Game game;
    public RedGuyApi api;
    public OkHttpClient okHttpClient;

    @Override
    public void onEnable() {
        Instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        Config.Load();
        Config.Save();

        if(Config.useRedGuyApi) {
            api = new RedGuyApi(Config.token);
        }
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
