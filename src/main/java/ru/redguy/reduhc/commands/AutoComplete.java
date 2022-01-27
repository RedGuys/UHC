package ru.redguy.reduhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import ru.redguy.reduhc.gamemodes.Events;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(command.getName().equalsIgnoreCase("uhc")) {
            List<String> complete = new ArrayList<>();
            if(args.length == 1) {
                complete.add("help");
                complete.add("add");
                complete.add("start");
                complete.add("info");
                complete.add("i");
                complete.add("stop");
                complete.removeIf(s -> !s.startsWith(args[0]));
            } else {
                switch (args[0]) {
                    case "add":
                        complete.addAll(Events.getMap().keySet());
                        complete.removeIf(s -> !s.startsWith(args[1]));
                        break;
                }
            }
            return complete;
        }
        return null;
    }
}
