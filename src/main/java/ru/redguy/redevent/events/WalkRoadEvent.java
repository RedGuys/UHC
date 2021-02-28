package ru.redguy.redevent.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.redguy.redevent.RedEvent;
import ru.redguy.redevent.utils.WhiteLists;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WalkRoadEvent implements Event {

    Map<Player, Material> blocksMap = new HashMap<>();

    @Override
    public String getEventName() {
        return "Ходячие дороги";
    }

    @Override
    public String getEventShortDescription() {
        return "Будет спавнить под вами блоки пока вы ходите с палкой в руках.";
    }

    @Override
    public String getEventFullDescription() {
        return "Пока вы держите в руках палку, под вами будут спавниться блоки.";
    }

    @Override
    public GameMode getGameMode() {
        return GameMode.SURVIVAL;
    }

    @Override
    public void Init() {
        for (Player alivePlayer : RedEvent.getGame().getPlayers()) {
            Material block = WhiteLists.blockSpawn[new Random().nextInt(WhiteLists.blockSpawn.length)];
            blocksMap.put(alivePlayer,block);
            alivePlayer.sendMessage("Твой блок " + block.name() + "!");
        }
    }

    @Override
    public void registerTimers() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void unRegisterTimers() {

    }

    @Override
    public void onDeath(PlayerDeathEvent event) {

    }

    @Override
    public void onDisconnect(PlayerQuitEvent event) {

    }

    @Override
    public void onDamage(EntityDamageEvent event, Player player) {

    }

    @Override
    public void onMoved(PlayerMoveEvent event) {
        Player player = event.getPlayer();;
        if(player.getInventory().getItemInMainHand().getType() == Material.STICK ||
                player.getInventory().getItemInOffHand().getType() == Material.STICK) {
            player.getLocation().subtract(0,1,0).getBlock().setType(blocksMap.get(player));
        }
    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {

    }
}
