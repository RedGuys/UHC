package ru.redguy.reduhc;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Messages {
    private static FileConfiguration configuration;

    public static List<String> playerJoin;
    public static String gameStateWait;

    public static void Load() {
        configuration = new YamlConfiguration();
        try {
            configuration.load(new File(RedUHC.Instance.getDataFolder(),"messages.yml"));
        } catch (IOException | InvalidConfigurationException e) {
            RedUHC.Instance.getLogger().warning("Error while loading messages");
        }
        configuration.options().copyDefaults(true);
        playerJoin = configuration.getStringList("chat.private.join");
        gameStateWait = configuration.getString("text.gamestate.wait");
    }

    public static void Save() {
        configuration.set("chat.private.join",playerJoin);
        configuration.set("text.gamestate.wait",gameStateWait);
        try {
            configuration.save(new File(RedUHC.Instance.getDataFolder(),"messages.yml"));
        } catch (IOException e) {
            RedUHC.Instance.getLogger().warning("Error while saving config");
        }
    }

    public static String getGameStateStringByState(GameState gameState) {
        switch (gameState) {
            case wait:
                return gameStateWait;
        }
        return "";
    }
}
