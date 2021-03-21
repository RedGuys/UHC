package ru.redguy.redevent.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.redguy.redevent.utils.PlayersUtils;

public class BloodOres implements Event {
    @Override
    public String getEventName() {
        return "Кровавыые руды";
    }

    @Override
    public String getEventShortDescription() {
        return "Вы будете получать урон при добыче руд.";
    }

    @Override
    public String getEventFullDescription() {
        return "В данном сценарии, игроки будут получать урон при добыче руд.";
    }

    @Override
    public GameMode getGameMode() {
        return GameMode.SURVIVAL;
    }

    @Override
    public void Init() {

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
    public void addTimerId(int id) {

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

    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {
        Material blockType = event.getBlock().getType();
        if (blockType == Material.COAL_ORE) {
            PlayersUtils.damagePlayer(event.getPlayer(),1.0);
        } else if(blockType == Material.IRON_ORE) {
            PlayersUtils.damagePlayer(event.getPlayer(),2.0);
        } else if(blockType == Material.LAPIS_ORE) {
            PlayersUtils.damagePlayer(event.getPlayer(),3.0);
        } else if(blockType == Material.GOLD_ORE) {
            PlayersUtils.damagePlayer(event.getPlayer(),4.0);
        } else if(blockType == Material.REDSTONE_ORE) {
            PlayersUtils.damagePlayer(event.getPlayer(),5.0);
        } else if(blockType == Material.DIAMOND_ORE) {
            PlayersUtils.damagePlayer(event.getPlayer(),6.0);
        } else if(blockType == Material.EMERALD_ORE) {
            PlayersUtils.damagePlayer(event.getPlayer(),7.0);
        }
    }
}
