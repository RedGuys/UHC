package ru.redguy.reduhc.utils;

import org.bukkit.entity.Player;
import ru.redguy.reduhc.Messages;
import ru.redguy.reduhc.RedUHC;

import java.util.List;

public class TextUtils {
    public static List<String> Join(Player player) {
        List<String> res = Messages.playerJoin;
        for (int i = 0; i < res.size(); i++) {
            res.set(i,parsePlaceholders(res.get(i),player));
        }
        return res;
    }

    public static String parsePlaceholders(String message, Player player) {
        message = message.replaceAll(
                "\\$gamestate\\$",
                Messages.getGameStateStringByState(RedUHC.getGame().gameState
                ));
        return message;
    }
}
