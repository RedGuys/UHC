package ru.redguy.redevent;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.redguy.redevent.commands.CommandsRegister;
import ru.redguy.redevent.utils.discord.HooksEvents;
import ru.redguy.redguyapi.RedGuyApi;

public final class RedEvent extends JavaPlugin {

    public static RedEvent INSTANCE;
    public Game activeGame;
    RedGuyApi api;

    @Override
    public void onEnable() {
        INSTANCE = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        Config.Load();
        Config.Save();

        if(Config.useRedGuyApi) {
            api = new RedGuyApi(Config.token);
        }
        CommandsRegister.register();
        Bukkit.getPluginManager().registerEvents(new HooksEvents(),this);
    }

    @Override
    public void onDisable() {
        Config.Save();
    }

    public static Game getGame() {
        return INSTANCE.activeGame;
    }
}
