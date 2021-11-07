package ru.redguy.reduhc.utils.discord;

import java.util.HashMap;
import java.util.Map;

public class Hook {
    public String url;
    public boolean notifyDeath;
    public boolean notifyWin;
    public boolean notifyAction;
    public boolean notifyStart;
    public boolean notifyServerStarted;
    public boolean notifyPlayerJoin;

    public Hook() {}

    public Hook(String url, boolean notifyDeath, boolean notifyWin, boolean notifyAction, boolean notifyStart,
                boolean notifyServerStarted, boolean notifyPlayerJoin) {
        this.url = url;
        this.notifyDeath = notifyDeath;
        this.notifyWin = notifyWin;
        this.notifyAction = notifyAction;
        this.notifyStart = notifyStart;
        this.notifyServerStarted = notifyServerStarted;
        this.notifyPlayerJoin = notifyPlayerJoin;
    }

    public Hook(Map<String,Object> map) {
        this.url = (String) map.get("url");
        this.notifyDeath = (boolean) map.getOrDefault("notifyDeath",false);
        this.notifyWin = (boolean) map.getOrDefault("notifyWin",false);
        this.notifyAction = (boolean) map.getOrDefault("notifyAction",false);
        this.notifyStart = (boolean) map.getOrDefault("notifyStart",false);
        this.notifyServerStarted = (boolean) map.getOrDefault("notifyServerStarted",false);
        this.notifyPlayerJoin = (boolean) map.getOrDefault("notifyPlayerJoin",false);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("url",url);
        map.put("notifyDeath",notifyDeath);
        map.put("notifyWin",notifyWin);
        map.put("notifyAction",notifyAction);
        map.put("notifyStart",notifyStart);
        map.put("notifyServerStarted",notifyServerStarted);
        map.put("notifyPlayerJoin",notifyPlayerJoin);
        return map;
    }
}
