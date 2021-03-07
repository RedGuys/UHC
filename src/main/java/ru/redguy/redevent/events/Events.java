package ru.redguy.redevent.events;

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
        /*res.put("HardOres",HardOres.class);
        res.put("DragonEscape",DragonEscape.class);
        res.put("HighLevel",HighLevel.class);
        res.put("SuperHeros",SuperHeros.class);
        res.put("WeakestDIE",WeakestDie.class);
        res.put("DogyTime",DogyTime.class);
        res.put("FlyTime",FlyTime.class);
        res.put("Flashers",Flashers.class);
        res.put("StoneMiners",StoneMiners.class);
        res.put("LavaWorld",LavaWorld.class);*/
        return res;
    }
}
