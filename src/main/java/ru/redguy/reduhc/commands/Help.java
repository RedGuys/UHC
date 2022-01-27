package ru.redguy.reduhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Help implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage("/uhc help [subcommand]");
            return true;
        }
        switch (args[0]) {
            case "help":
                sender.sendMessage("/uhc help [subcommand]");
                break;
            case "add":
                sender.sendMessage("/uhc add [scenario]");
                break;
            case "start":
                sender.sendMessage("/uhc start");
                break;
            case "i":
            case "info":
                sender.sendMessage("/uhc info");
                break;
            case "stop":
                sender.sendMessage("/uhc stop");
                break;
            default:
                sender.sendMessage("Unknown subcommand!");
                break;
        }
        return true;
    }
}
