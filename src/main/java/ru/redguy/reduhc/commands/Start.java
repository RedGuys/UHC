package ru.redguy.reduhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.reduhc.GameState;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.utils.CommandsUtils;

public class Start implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(CommandsUtils.checkPermissions(sender,"redevents.command.start")) {
            if (RedUHC.getGame().gameState == GameState.wait) {
                if (Bukkit.getOnlinePlayers().size() > 1) {
                    if(RedUHC.getGame().getScenariosCount() > 0) {
                        RedUHC.getGame().start();
                    } else {
                        sender.sendMessage("Сценарий не добавлен!");
                    }
                } else {
                    sender.sendMessage("Недостаточно игроков!");
                }
            } else {
                sender.sendMessage("Игра уже началась!");
            }
        }
        return true;
    }
}
