package ru.redguy.redevent.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Help implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("/event []");
        return true;
    }
}
