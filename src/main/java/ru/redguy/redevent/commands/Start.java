package ru.redguy.redevent.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.redevent.GameState;
import ru.redguy.redevent.RedEvent;
import ru.redguy.redevent.utils.CommandsUtils;

public class Start implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(CommandsUtils.checkPermissions(sender,"redevents.command.start")) {
            if (RedEvent.getGame().gameState == GameState.wait) {
                if (Bukkit.getOnlinePlayers().size() > 1) {
                    if(RedEvent.getGame().getScenariosCount() > 0) {
                        RedEvent.getGame().start();
                    } else {
                        sender.sendMessage("Сценарий не добавлен!");
                    }
                } else {
                    sender.sendMessage("Недостаточно игроков!");
                }
            } else {
                sender.sendMessage("Игра уже началась!");
            }
        }
        return true;
    }
}
