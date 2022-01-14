package ru.redguy.reduhc;

import ru.redguy.reduhc.utils.ConfigFile;

public class Config {
    private static ConfigFile config;

    public static void Load() {
        config = new ConfigFile(RedUHC.getInstance().getConfig(),"config");
    }

    public static void Save() {
        config.save();
    }
}
