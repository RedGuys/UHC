package ru.redguy.redevent.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage("/event []");
            return false;
        }
        List<String> a = Arrays.asList(args);
        String subcommand = a.get(0);
        a.remove(0);
        args = a.toArray(new String[0]);
        switch (subcommand) {
            case "help":
                return new Help().onCommand(sender,command,label,args);
        }
        return true;
    }
}
