package ru.redguy.redevent.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(command.getName().equalsIgnoreCase("event")) {
            List<String> complete = new ArrayList<>();
            if(args.length == 1) {
                complete.add("help");
                complete.add("start");
            } else {
                switch (args[0]) {
                    case "start":
                        complete.add("evest");
                        break;
                }
            }
            return complete;
        }
        return null;
    }
}
