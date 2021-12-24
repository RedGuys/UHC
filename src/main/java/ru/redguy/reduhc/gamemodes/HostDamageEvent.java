package ru.redguy.reduhc.gamemodes;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.redguy.reduhc.RedUHC;
import ru.redguy.reduhc.utils.ChatUtils;
import ru.redguy.reduhc.utils.PlayersUtils;

public class HostDamageEvent implements Event {

    Player host;

    @Override
    public String getEventName() {
        return "Урон одного";
    }

    @Override
    public String getEventShortDescription() {
        return "Заставит вас получать урон хоста игры.";
    }

    @Override
    public String getEventFullDescription() {
        return "В данном сценарии, урон полученый хостом будет повторяться на всех других игроках.";
    }

    @Override
    public GameMode getGameMode() {
        return GameMode.SURVIVAL;
    }

    @Override
    public void Init() {
        host = PlayersUtils.getRandomAlivePlayer();
        ChatUtils.sendToAll("Хостом выбран " + host.getDisplayName() + "!");
    }

    @Override
    public void registerTimers() {

    }

    @Override
    public void stop() {
        host = null;
    }

    @Override
    public void unRegisterTimers() {

    }

    @Override
    public void addTimerId(int id) {

    }

    @Override
    public void onDeath(PlayerDeathEvent event) {

    }

    @Override
    public void onDamage(EntityDamageEvent event, Player player) {
        if (player.equals(host)) {
            for (Player alivePlayer : RedUHC.getGame().getPlayers()) {
                if (!alivePlayer.equals(host)) {
                    alivePlayer.damage(event.getDamage(),player);
                }
            }
        }
    }

    @Override
    public void onDisconnect(PlayerQuitEvent event) {

    }

    @Override
    public void onMoved(PlayerMoveEvent event) {

    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {

    }
}
