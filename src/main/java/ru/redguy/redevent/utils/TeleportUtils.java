package ru.redguy.redevent.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class TeleportUtils {
    public static Location getSafeLocation(int x, int z) {
        World world = WorldsUtils.getDefaultWorld();
        for (int y = 255; y > 1; y--) {
            Block block = world.getBlockAt(x,y,z);
            if(block.getType() != Material.AIR) {
                return new Location(world,x,y+2,z);
            }
        }
        return null;
    }
}
