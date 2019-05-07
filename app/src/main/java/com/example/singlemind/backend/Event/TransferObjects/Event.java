package com.example.singlemind.backend.Event.TransferObjects;

import java.time.LocalDateTime;

public final class Event extends NewEvent {
    public Event(int EventID, int UserID,
                    String EventName, String EventDesc,
                    LocalDateTime EventDate, LocalDateTime CreationDate){
        super(UserID, EventName, EventDesc, EventDate);
        this.EventID = EventID;
        this.CreationDate = CreationDate;
    }
    public Event(){
        super();
        this.EventID = 0;
        this.CreationDate = null;
    }

    public int getEventID(){return this.EventID;}
    public LocalDateTime getCreationDate(){return this.CreationDate;}

    private final int EventID;
    private final LocalDateTime CreationDate;
}
