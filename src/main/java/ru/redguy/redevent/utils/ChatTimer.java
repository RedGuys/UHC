package ru.redguy.redevent.utils;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import ru.redguy.redevent.RedEvent;

import java.util.concurrent.TimeUnit;

public class ChatTimer {

    private int seconds;
    private BukkitTask timerTask;
    private String name;

    public ChatTimer(int seconds, String name) {
        this.seconds = seconds;
        this.name = name;
    }

    public void Start() {
        timerTask = Bukkit.getScheduler().runTaskTimer(RedEvent.INSTANCE,new Notifer(),0,20);
    }

    public BukkitTask getTimerTask() {
        return timerTask;
    }

    private class Notifer implements Runnable {

        @Override
        public void run() {
            seconds--;
            String secondName = "";
            switch (seconds) {
                case 60:
                case 30:
                case 15:
                case 10:
                case 5:
                    secondName = "секунд";
                    break;
                case 4:
                case 3:
                case 2:
                    secondName = "секунды";
                    break;
                case 1:
                    secondName = "секунда";
                    break;
                case 0:
                    timerTask.cancel();
                    break;
            }
            if(!secondName.equals("")) {
                ChatUtils.sendToAll("До " + name + " осталось "+seconds+" "+secondName);
            }
        }
    }
}
