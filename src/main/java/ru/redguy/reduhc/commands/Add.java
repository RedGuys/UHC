package ru.redguy.reduhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.reduhc.GameState;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.events.Events;
import ru.redguy.reduhc.utils.CommandsUtils;

public class Add implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(CommandsUtils.checkPermissions(sender,"redevents.command.add")) {
            if(args.length > 0) {
                if (Events.getMap().containsKey(args[0])) {
                    if (RedUHC.getGame().gameState == GameState.wait) {
                        try {
                            RedUHC.getGame().addScenarios((ru.redguy.reduhc.events.Event) Events.getMap().get(args[0]).newInstance());
                            sender.sendMessage("Добавлено!");
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
                sender.sendMessage("Ивент не выбран!");
            }
        }
        return true;
    }
}
