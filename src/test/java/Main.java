import ru.redguy.redevent.utils.discord.Embed;
import ru.redguy.rednetworker.clients.http.ApacheFluentAPI;
import ru.redguy.rednetworker.clients.http.HttpMethod;
import ru.redguy.rednetworker.clients.http.exceptions.HttpProtocolException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] args) {
        //send("https://dev.redguy.ru/test.php",new Embed().setDescription("На русском").setTitle("Титл"));
    }

    public static void send(String url, Embed embed) {
        new Thread(() -> {
            ApacheFluentAPI apacheFluentAPI = new ApacheFluentAPI();
            try {
                System.out.println(apacheFluentAPI.url(url).method(HttpMethod.POST).setRequestCharset(StandardCharsets.UTF_8).setContentType("application/json").setPostBody(embed.toJson()).execute().getString());
            } catch (IOException ignored) { } catch (HttpProtocolException e) {
                System.out.println(e.getResponse().getString());
            }
        }).start();
    }
}
