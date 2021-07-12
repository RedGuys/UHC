package ru.redguy.redevent.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Help implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage("/event help [subcommand]");
            return true;
        }
        switch (args[0]) {
            case "help":
                sender.sendMessage("/event help [subcommand]");
                break;
            case "add":
                sender.sendMessage("/event add [EventName]");
                break;
            case "start":
                sender.sendMessage("/event start");
                break;
            case "i":
            case "info":
                sender.sendMessage("/event info");
                break;
            case "stop":
                sender.sendMessage("/event stop");
                break;
            default:
                sender.sendMessage("Unknown subcommand!");
                break;
        }
        return true;
    }
}
