package com.example.singlemind.backend.Event.TransferObjects;

import com.example.singlemind.Globals;

import java.util.List;

public class Events {
    public List<Event> events;

    public Events(List<Event> evnt) {
        int uid = Globals.getInstance().user.getUserID();
        if (!evnt.isEmpty())
            for (int i = 0; i < evnt.size(); i++)
                events.add(evnt.get(i).getEventByUserID(uid));
    }
}
