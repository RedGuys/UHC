package ru.redguy.redevent.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.redevent.GameState;
import ru.redguy.redevent.RedEvent;
import ru.redguy.redevent.events.Events;

public class Add implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Events.getMap().containsKey(args[0])) {
            if(RedEvent.getGame().gameState == GameState.wait) {
                try {
                    RedEvent.getGame().addScenarios((ru.redguy.redevent.events.Event) Events.getMap().get(args[0]).newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    sender.sendMessage("Что-то пошло не так!");
                }
            } else {
                sender.sendMessage("Игра уже началась!");
            }
        } else {
            sender.sendMessage("Сценарий не найден!");
        }
        return true;
    }
}
