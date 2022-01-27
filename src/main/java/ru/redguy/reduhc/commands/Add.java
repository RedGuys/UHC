package ru.redguy.reduhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.reduhc.GameState;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.gamemodes.Event;
import ru.redguy.reduhc.gamemodes.Events;
import ru.redguy.reduhc.utils.CommandsUtils;

public class Add implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(CommandsUtils.checkPermissions(sender,"redevents.command.add")) {
            if(args.length > 0) {
                if (Events.getMap().containsKey(args[0])) {
                    if (RedUHC.getGame().gameState == GameState.wait) {
                        try {
                            Event ev = (Event) Events.getMap().get(args[0]).newInstance();
                            RedUHC.getGame().addScenarios(ev);
                            sender.sendMessage("Сценарий "+ev.getEventName()+" был добавлен!");
                        } catch (InstantiationException | IllegalAccessException e) {
                            sender.sendMessage("Что-то пошло не так!");
                        }
                    } else {
                        sender.sendMessage("Игра уже началась!");
                    }
                } else {
                    sender.sendMessage("Сценарий не найден!");
                }
            } else {
                sender.sendMessage("Сценарий не выбран!");
            }
        }
        return true;
    }
}
