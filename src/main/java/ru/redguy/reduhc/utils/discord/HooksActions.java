package ru.redguy.reduhc.utils.discord;

import org.bukkit.entity.Player;

public class HooksActions {
    public static void OnDeath(Player player) {
        /*Embed embed = new Embed();
        embed.setTitle(player.getName()+" умер!");
        embed.appendField(new Field()
                .setName("Убийств")
                .setValue(String.valueOf(RedUHC.getGame().getPlayerKills(player))));
        for (Hook hook : Config.hooks) {
            if(hook.notifyDeath) {
                try {
                    send(hook.url, embed);
                } catch (Exception ignored) {}
            }
        }*/
    }

    /*public static void send(String url, Embed embed) {
        new Thread(() -> {
            try {
                HttpUtils.Post(url, embed.toJson(), new HashMap<>());
            } catch (IOException ignored) { }
        }).start();
    }*/
}
