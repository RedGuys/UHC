package ru.redguy.reduhc.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

public class WorldsUtils {
    public static World getDefaultWorld() {
        return Bukkit.getWorlds().get(0);
    }

    public static void spawnEntity(EntityType entityType, Location spawnLocation) {
        World world = spawnLocation.getWorld();
        world.spawnEntity(spawnLocation,entityType);
    }

    public static void spawnDragon(Location spawnLocation) {
        World world = spawnLocation.getWorld();
        EnderDragon enderDragon = (EnderDragon) world.spawnEntity(spawnLocation,EntityType.ENDER_DRAGON);
        enderDragon.setPhase(EnderDragon.Phase.LEAVE_PORTAL);
    }

    public static void spawnDog(Player player) {
        Wolf dog = (Wolf) player.getLocation().getWorld().spawnEntity(player.getLocation(),EntityType.WOLF);
        dog.setTamed(true);
        dog.setOwner(player);
    }
}
