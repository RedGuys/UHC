package ru.redguy.redevent.utils;

public class Runnables {
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

        public Timer(String text, int seconds) {
            this.text = text;
            this.seconds = seconds;
        }

        public void run() {
            ChatTimer chatTimer = new ChatTimer(seconds,text);
            chatTimer.Start();
        }
    }
}
