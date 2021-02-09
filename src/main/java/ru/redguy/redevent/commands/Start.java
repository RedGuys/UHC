package ru.redguy.redevent.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import ru.redguy.redevent.GameState;
import ru.redguy.redevent.RedEvent;

public class Start implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(RedEvent.getGame().gameState == GameState.wait) {
            RedEvent.getGame().start();
        } else {
            sender.sendMessage("Игра уже началась!");
        }
        return true;
    }
}
