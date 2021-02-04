package ru.redguy.redevent.utils.discord;

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
}
