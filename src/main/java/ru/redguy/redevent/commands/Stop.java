package ru.redguy.redevent.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.redevent.RedEvent;
import ru.redguy.redevent.utils.CommandsUtils;

public class Stop implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(CommandsUtils.checkPermissions(sender,"redevents.command.stop")) {
            RedEvent.getGame().stop();
            return true;
        }
        return false;
    }
}
