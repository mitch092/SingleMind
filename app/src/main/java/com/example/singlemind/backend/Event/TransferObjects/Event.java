package com.example.singlemind.backend.Event.TransferObjects;

import java.time.LocalDateTime;

public class Event extends NewEvent {
    public Event(int EventID, int UserID,
                    String EventName, String EventDesc,
                    String EventDate, String CreationDate){
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
    public String getCreationDate(){return this.CreationDate;}

    protected final int EventID;
    protected final String CreationDate;
}
