package ru.redguy.reduhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.utils.CommandsUtils;

public class Stop implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(CommandsUtils.checkPermissions(sender,"redevents.command.stop")) {
            RedUHC.getGame().stop();
            return true;
        }
        return false;
    }
}
