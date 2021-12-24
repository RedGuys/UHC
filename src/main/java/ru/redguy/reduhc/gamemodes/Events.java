package ru.redguy.reduhc.gamemodes;

import java.util.HashMap;

public class Events {
    public static HashMap<String, Class<?>> getMap() {
        HashMap<String, Class<?>> res = new HashMap<>();
        res.put("PositionSwap",PositionSwapEvent.class);
        res.put("InventorySwap", InventorySwapEvent.class);
        res.put("HostDamage",HostDamageEvent.class);
        res.put("RandomBlockSpawn",RandomBlockSpawnEvent.class);
        res.put("WalkRoad",WalkRoadEvent.class);
        res.put("FurnaceWar",FurnaceWar.class);
        res.put("BloodOres",BloodOres.class);
        res.put("HardOres",HardOres.class);
        res.put("DragonEscape",DragonEscape.class);
        res.put("HighestDeath",HighestDeath.class);
        res.put("SuperHeros",SuperHeros.class);
        res.put("WeakestDie",WeakestDie.class);
        res.put("DoggyTime",DoggyTime.class);
        return res;
    }
}
