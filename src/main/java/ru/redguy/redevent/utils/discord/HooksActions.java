package ru.redguy.redevent.utils.discord;

import org.bukkit.entity.Player;
import ru.redguy.redevent.Config;
import ru.redguy.redevent.RedEvent;
import ru.redguy.rednetworker.clients.http.ApacheFluentAPI;
import ru.redguy.rednetworker.clients.http.HttpMethod;
import ru.redguy.rednetworker.clients.http.exceptions.HttpProtocolException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HooksActions {
    public static void OnDeath(Player player) {
        Embed embed = new Embed();
        embed.setTitle(player.getName()+" умер!");
        embed.appendField(new Field()
                .setName("Убийств")
                .setValue(String.valueOf(RedEvent.getGame().getPlayerKills(player))));
        for (Hook hook : Config.hooks) {
            if(hook.notifyDeath) {
                try {
                    send(hook.url, embed);
                } catch (Exception ignored) {}
            }
        }
    }

    public static void send(String url, Embed embed) {
        new Thread(() -> {
            ApacheFluentAPI apacheFluentAPI = new ApacheFluentAPI();
            try {
                apacheFluentAPI.url(url).method(HttpMethod.POST).setRequestCharset(StandardCharsets.UTF_8).setContentType("application/json").setPostBody(embed.toJson()).execute();
            } catch (IOException ignored) { } catch (HttpProtocolException e) {
                System.out.println(e.getResponse().getString());
            }
        }).start();
    }
}
