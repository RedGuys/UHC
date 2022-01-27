package ru.redguy.reduhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.gamemodes.Event;

public class Info implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(RedUHC.getGame().getScenarios().size()>0) {
            sender.sendMessage("Добавленные сценарии:");
            for (Event scenario : RedUHC.getGame().getScenarios()) {
                sender.sendMessage(scenario.getEventName() + ": " + scenario.getEventShortDescription());
            }
        } else {
            sender.sendMessage("Нет активных сценариев");
        }
        return true;
    }
}
