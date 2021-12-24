package ru.redguy.reduhc.utils;

import ru.redguy.reduhc.gamemodes.Event;

import java.util.List;

public class ListUtils {
    public static boolean isScenariosAdded(List<Event> events, Event event) {
        for (Event ev : events) {
            if(ev.getEventName().equals(event.getEventName())) return true;
        }
        return false;
    }
}
