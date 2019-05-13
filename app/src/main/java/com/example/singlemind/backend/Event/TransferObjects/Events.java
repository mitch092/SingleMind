package com.example.singlemind.backend.Event.TransferObjects;

import com.example.singlemind.Globals;
import com.example.singlemind.backend.Event.AccessObjects.EventAccess2;

import java.util.List;

public class Events {
    public List<Event> events;
    public int[] IDs;
    private int uid;
    EventAccess2 eventDB = new EventAccess2();

    public Events(List<Event> evnt) {
        uid = Globals.getInstance().user.getUserID();
        if (!evnt.isEmpty())
            for (int i = 0; i < evnt.size(); i++) {
                events.add(evnt.get(i).getEventByUserID(uid));
                IDs[i] = evnt.get(i).getEventID();
            }
    }

    public Event getEventByIndex(int pos) {
        //Event event = new Event();
        //int index = events.indexOf(pos);
        return events.get(pos);
        //return events.get(events.size()-1);
    }

    public int getEventIdByIndex(int pos) {
        return IDs[pos];
    }

    public Event getEventByID(int eid)
    {
        boolean isFound = false;
        for (int i = 0; i < IDs.length && !isFound; i++) {
            if(eid == IDs[i]) {
                isFound = true;
                return events.get(i);
            }
            else isFound = false;
        }
        if (isFound) return events.get(events.lastIndexOf(events));
        else return events.get(events.lastIndexOf(events));
    }

    public Events () {
        /*
        uid = Globals.getInstance().user.getUserID();
        List<Event> evnt = eventDB.getEventsByUserId(uid).events;
        if (!evnt.isEmpty())
            for (int i = 0; i < evnt.size(); i++) {
                events.add(evnt.get(i).getEventByUserID(uid));
                IDs[i] = evnt.get(i).getEventID();
            }
            */
    }
}
