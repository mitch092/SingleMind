package com.example.singlemind.backend.Event.TransferObjects;

import com.example.singlemind.Globals;

import java.util.ArrayList;

public class Events {
    public ArrayList<Event> events;

    public Events(ArrayList<Event> evnt) {
        int uid = Globals.getInstance().user.getUserID();
        if (!evnt.isEmpty())
            for (int i = 0; i < evnt.size(); i++)
                events.add(evnt.get(i).getEvent(uid));
    }

    public Events() {

    }
}
