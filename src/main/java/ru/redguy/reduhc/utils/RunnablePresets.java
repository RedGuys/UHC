package ru.redguy.reduhc.utils;

import ru.redguy.reduhc.gamemodes.Event;

public class RunnablePresets {
    public static class PvpOn implements Runnable {

        @Override
        public void run() {
            WorldsUtils.getDefaultWorld().setPVP(true);
            ChatUtils.sendToAll("PVP on!");
        }
    }

    public static class Barrier implements Runnable {

        long size;

        public Barrier(long size) {
            this.size = size;
        }

        @Override
        public void run() {
            WorldsUtils.getDefaultWorld().getWorldBorder().setSize(size,120);
            ChatUtils.sendToAll("Барьер уменьшается до "+size+" блоков");
        }
    }

    public static class MessageSend implements Runnable {

        String text;

        public MessageSend(String text) {
            this.text = text;
        }

        @Override
        public void run() {
            ChatUtils.sendToAll(text);
        }
    }

    public static class Timer implements Runnable {

        String text;
        int seconds;
        Event event;

        public Timer(String text, int seconds, Event event) {
            this.text = text;
            this.seconds = seconds;
            this.event = event;
        }

        public void run() {
            ChatTimer chatTimer = new ChatTimer(seconds,text,event);
            chatTimer.Start();
        }
    }
}
