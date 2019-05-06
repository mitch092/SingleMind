package com.example.singlemind.backend.Event;

import java.time.LocalDateTime;

public class Event {
    private int priority = 0; //check
    private String eventName = "";
    private String eventDesciption = "";
    private String definedType = ""; //check
    private LocalDateTime dateTime;

    public void setPriority(int p){
        if(p < 0 || p > 9)
            ;
        else
            priority = p;
    }

    public int getPriority() { return priority; }

    public void setEventName(String name) {
        eventName = name;
    }

    public String getEventName() { return eventName; }

    public void setEventDesciption(String desc) {
        eventDesciption = desc;
    }

    public String getEventDesciption() { return eventDesciption; }

    public void setEventType(String type) {
        definedType = type;
    }

    public String getEventType() { return definedType; }

    public void setDateTime(LocalDateTime dt) {
        dateTime = dt;
    }

    public LocalDateTime getDateTime() { return dateTime; }

    public Event createEvent(int p, String n, String d, String t, LocalDateTime ldt) {
        setPriority(p);
        setEventName(n);
        setEventDesciption(d);
        setEventType(t);
        setDateTime(ldt);
        return this;
    }
}
