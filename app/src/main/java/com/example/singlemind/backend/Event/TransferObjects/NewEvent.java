package com.example.singlemind.backend.Event.TransferObjects;

import com.example.singlemind.backend.User.TransferObjects.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewEvent {
    public NewEvent(int UserID,
                    String EventName, String EventDesc,
                    LocalDateTime EventDate){
        this.UserID = UserID;
        this.EventName = EventName;
        this.EventDesc = EventDesc;
        this.EventDate = EventDate;
    }
    public NewEvent(){
        this.UserID = 0;
        this.EventName = "";
        this.EventDesc = "";
        this.EventDate = null;
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

    private final int UserID;
    private final String EventName;
    private final String EventDesc;
    private final LocalDateTime EventDate;
}
