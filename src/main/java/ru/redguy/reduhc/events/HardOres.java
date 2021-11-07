package ru.redguy.reduhc.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class HardOres implements Event {
    @Override
    public String getEventName() {
        return "Прочные руды";
    }

    @Override
    public String getEventShortDescription() {
        return "После каждой добытой руды ваша кирка будет ломаться";
    }

    @Override
    public String getEventFullDescription() {
        return "Ломая руды, вы будете ломать кирки";
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
        if (blockType == Material.COAL_ORE || blockType == Material.IRON_ORE || blockType == Material.LAPIS_ORE || blockType == Material.GOLD_ORE || blockType == Material.REDSTONE_ORE || blockType == Material.DIAMOND_ORE || blockType == Material.EMERALD_ORE) {
            event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
            event.getPlayer().getInventory().addItem(new ItemStack(blockType));
        }
    }
}
