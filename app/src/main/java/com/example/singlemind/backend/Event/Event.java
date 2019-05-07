package com.example.singlemind.backend.Event;

import com.example.singlemind.backend.User.TransferObjects.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Event {
    public Event(int EventID, int UserID,
                 String EventName, String EventDesc,
                 LocalDateTime EventDate, LocalDateTime CreationDate){
        this.EventID = EventID;
        this.UserID = UserID;
        this.EventName = EventName;
        this.EventDesc = EventDesc;
        this.EventDate = EventDate;
        this.CreationDate = CreationDate;
    }
    public Event(){
        this.EventID = 0;
        this.UserID = 0;
        this.EventName = "";
        this.EventDesc = "";
        this.EventDate = null;
        this.CreationDate = null;
    }

    public int getEventID(){
        return this.EventID;
    }
    public int getUserID(){
        return this.UserID;
    }
    public String getEventName(){
        return this.EventName;
    }
    public String getEventDesc(){
        return this.EventDesc;
    }
    public LocalDateTime getEventDate(){
        return this.EventDate;
    }
    public LocalDateTime getCreationDate(){
        return this.CreationDate;
    }

    private final int EventID;
    private final int UserID;
    private final String EventName;
    private final String EventDesc;
    private final LocalDateTime EventDate;
    private final LocalDateTime CreationDate;
}
