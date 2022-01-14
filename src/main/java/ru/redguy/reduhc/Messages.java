package ru.redguy.reduhc;

import ru.redguy.reduhc.utils.ConfigFile;

import java.util.List;

public class Messages {
    private static ConfigFile configuration;

    public static void Load() {
        configuration = new ConfigFile("messages");
        configuration.def("game.gamestate.wait","ожидание начала");
        configuration.def("game.gamestate.active","активна");
        configuration.def("chat.joinText",new String[] {"Добро пожаловать на UHC!","Статус игры: $gamestate$"});
        Save();
    }

    public static void Save() {
        configuration.save();
    }

    public static String getGameStateStringByState(GameState gameState) {
        switch (gameState) {
            case wait:
                return configuration.getString("game.gamestate.wait");
            case active:
                return configuration.getString("game.gamestate.active");
        }
        return "";
    }

    public static List<String> getJoinText() {
        return configuration.getStringList("chat.joinText");
    }
}
