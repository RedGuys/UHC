package ru.redguy.reduhc.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.redguy.reduhc.RedUHC;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigFile {
    File configFile;
    FileConfiguration conf = new YamlConfiguration();

    public ConfigFile(String name) {
        configFile = new File(RedUHC.getInstance().getDataFolder(), name + ".yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException ignored) {

            }
        }
        try {
            conf.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            RedUHC.getInstance().getLogger().warning("Failed to load " + name + " config! ");
            e.printStackTrace();
        }
    }

    public ConfigFile(FileConfiguration conf, String name) {
        configFile = new File(RedUHC.getInstance().getDataFolder(), name + ".yml");
        this.conf = conf;
    }

    public void save() {
        try {
            conf.save(configFile);
        } catch (IOException ignored) {
        }
    }

    public void def(String name, Object value) {
        if (conf.get(name) == null) {
            conf.set(name, value);
        }
    }

    public void set(String name, Object value) {
        conf.set(name, value);
    }

    public boolean getBoolean(String name) {
        return conf.getBoolean(name);
    }

    public String getString(String name) {
        return conf.getString(name);
    }

    public List<String> getStringList(String name) {
        return conf.getStringList(name);
    }
}