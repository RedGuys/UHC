package ru.redguy.reduhc.utils;

import org.bukkit.Bukkit;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.events.Event;

public class ChatTimer {

    private int seconds;
    private int timerTask;
    private String name;
    private Event event;

    public ChatTimer(int seconds, String name, Event event) {
        this.seconds = seconds;
        this.name = name;
        this.event = event;
    }

    public void Start() {
        timerTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(RedUHC.Instance,new Notifer(),0,20);
        event.addTimerId(timerTask);
    }

    public int getTimerTaskId() {
        return timerTask;
    }

    private class Notifer implements Runnable {

        @Override
        public void run() {
            String cName = null;
            if(seconds<61) {
                String ost = "осталось";
                switch (seconds) {
                    case 60:
                    case 30:
                    case 15:
                    case 10:
                    case 5:
                        cName = "секунд";
                        break;
                    case 4:
                    case 3:
                    case 2:
                        cName = "секунды";
                        break;
                    case 1:
                        cName = "секунда";
                        ost = "осталась";
                        break;
                    case 0:
                        Bukkit.getScheduler().cancelTask(timerTask);
                        break;
                }
                if (cName != null) {
                    ChatUtils.sendToAll("До " + name + " " + ost + " " + seconds + " " + cName);
                }
            } else {
                switch (seconds) {
                    case 300:
                        cName = "минут";
                        break;
                    case 240:
                    case 180:
                    case 120:
                        cName = "минуты";
                        break;
                }
                if (cName != null) {
                    ChatUtils.sendToAll("До " + name + " осталось " + (seconds/60) + " " + cName);
                }
            }
            seconds--;
        }
    }
}
