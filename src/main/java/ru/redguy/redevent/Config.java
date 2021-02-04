package ru.redguy.redevent;

import org.bukkit.configuration.file.FileConfiguration;
import ru.redguy.redevent.utils.discord.Hook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Config {
    public static List<Hook> hooks;
    public static boolean useRedGuyApi;
    public static String token;

    public static void Load() {
        FileConfiguration configuration = RedEvent.INSTANCE.getConfig();
        hooks = (List<Hook>) configuration.getList("discord.hooks",new ArrayList<Hook>());
        useRedGuyApi = configuration.getBoolean("redguy.useapi",false);
        token = configuration.getString("redguy.token","");
    }

    public static void Save() {
        FileConfiguration configuration = RedEvent.INSTANCE.getConfig();
        configuration.set("discord.hooks",hooks);
        configuration.set("redguy.useapi",useRedGuyApi);
        configuration.set("redguy.token",token);
        try {
            configuration.save(new File(RedEvent.INSTANCE.getDataFolder(),"config.yml"));
        } catch (IOException e) {
            RedEvent.INSTANCE.getLogger().warning("Error while saving config");
        }
    }
}
