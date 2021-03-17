package ru.redguy.redevent.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.redevent.RedEvent;
import ru.redguy.redevent.events.Event;

public class Info implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (Event scenario : RedEvent.getGame().getScenarios()) {
            sender.sendMessage(scenario.getEventName()+": "+scenario.getEventShortDescription());
        }
        return true;
    }
}
