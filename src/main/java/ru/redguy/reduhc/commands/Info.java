package ru.redguy.reduhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.gamemodes.Event;

public class Info implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (Event scenario : RedUHC.getGame().getScenarios()) {
            sender.sendMessage(scenario.getEventName()+": "+scenario.getEventShortDescription());
        }
        return true;
    }
}
