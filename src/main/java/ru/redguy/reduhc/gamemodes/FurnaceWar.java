package ru.redguy.reduhc.gamemodes;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceWar implements Event {
    @Override
    public String getEventName() {
        return "Война против печей";
    }

    @Override
    public String getEventShortDescription() {
        return "Добытые руды выпадают блоками";
    }

    @Override
    public String getEventFullDescription() {
        return "В данном ивенте, вам не нужны печки так как руды будут плавится сами.";
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
        if (blockType == Material.IRON_ORE) {
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            event.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_BLOCK));
        } else if(blockType == Material.GOLD_ORE) {
            event.setCancelled(true);
            event.getBlock().setType(Material.AIR);
            event.getPlayer().getInventory().addItem(new ItemStack(Material.GOLD_BLOCK));
        }
    }
}
