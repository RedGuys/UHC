package ru.redguy.reduhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;

public class UHC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            return false;
        }
        ArrayList<String> a = new ArrayList<>(Arrays.asList(args));
        String subcommand = a.get(0);
        a.remove(0);
        args = a.toArray(new String[0]);
        switch (subcommand.toLowerCase()) {
            case "help":
                return new Help().onCommand(sender,command,label,args);
            case "add":
                return new Add().onCommand(sender,command,label,args);
            case "start":
                return new Start().onCommand(sender, command, label, args);
            case "i":
            case "info":
                return new Info().onCommand(sender, command, label, args);
            case "stop":
                return new Stop().onCommand(sender, command, label, args);
        }
        return true;
    }
}
