package ru.redguy.redevent.utils;

import org.bukkit.command.CommandSender;

public class CommandsUtils {
    public static boolean checkPermissions(CommandSender sender, String permission) {
        if(!sender.hasPermission(permission)) {
            sender.sendMessage("Недостаточно прав!");
            return false;
        }
        return true;
    }
}
