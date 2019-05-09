package com.example.singlemind.backend.Event.TransferObjects;

import com.example.singlemind.backend.User.TransferObjects.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewEvent {
    public NewEvent(int UserID,
                    String EventName, String EventDesc,
                    String EventDate){
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
    public String getEventDate(){
        return this.EventDate;
    }

    public void setEventName(String eventName){
        this.EventName = eventName;
    }

    public void setEventDesc(String eventDesc){
        this.EventDesc = eventDesc;
    }

    public void setEventDate(String eventDate){
        this.EventDate = eventDate;
    }

    protected final int UserID;
    protected String EventName;
    protected String EventDesc;
    protected String EventDate;
}
