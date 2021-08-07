package ru.redguy.redevent;

import org.bukkit.configuration.file.FileConfiguration;
import ru.redguy.redevent.utils.discord.Hook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Config {
    public static List<Hook> hooks;
    public static boolean useRedGuyApi;
    public static String token;

    public static void Load() {
        FileConfiguration configuration = RedEvent.Instance.getConfig();
        hooks = new ArrayList<>();
        for (Map<?, ?> map : configuration.getMapList("discord.hooks")) {
            hooks.add(new Hook((Map<String, Object>) map));
        }
        useRedGuyApi = configuration.getBoolean("redguy.useapi",false);
        token = configuration.getString("redguy.token","");
    }

    public static void Save() {
        FileConfiguration configuration = RedEvent.Instance.getConfig();
        List<Map<String, Object>> list = new ArrayList<>();
        for (Hook hook : hooks) {
            list.add(hook.toMap());
        }
        configuration.set("discord.hooks",list);
        configuration.set("redguy.useapi",useRedGuyApi);
        configuration.set("redguy.token",token);
        try {
            configuration.save(new File(RedEvent.Instance.getDataFolder(),"config.yml"));
        } catch (IOException e) {
            RedEvent.Instance.getLogger().warning("Error while saving config");
        }
    }
}
