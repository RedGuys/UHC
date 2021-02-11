package ru.redguy.redevent.utils;

import ru.redguy.redevent.events.Event;

import java.util.List;

public class ListUtils {
    public static boolean isScenariosAdded(List<Event> events, Event event) {
        for (Event ev : events) {
            if(ev.getEventName().equals(event.getEventName())) return true;
        }
        return false;
    }
}
