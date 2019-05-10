package com.example.singlemind.backend.Event.TransferObjects;

import com.example.singlemind.backend.User.TransferObjects.User;

import java.time.LocalDateTime;

public class Event {
    public Event(int UserID, String EventName,
                 String EventDesc, String EventDate){

        this.UserID = UserID;
        this.EventName = EventName;
        this.EventDesc = EventDesc;
        this.EventDate = EventDate;
        this.EventID = -1;
        this.CreationDate = "";
    }
    public Event(){
        this.UserID = -1;
        this.EventName = "";
        this.EventDesc = "";
        this.EventDate = "";
        this.EventID = -1;
        this.CreationDate = "";
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
    public int getEventID(){return this.EventID;}
    public String getCreationDate(){return this.CreationDate;}

    public void setEventName(String eventName){
        this.EventName = eventName;
    }
    public void setEventDesc(String eventDesc){
        this.EventDesc = eventDesc;
    }
    public void setEventDate(String eventDate){
        this.EventDate = eventDate;
    }

    private int UserID;
    private String EventName;
    private String EventDesc;
    private String EventDate;
    private int EventID;
    private String CreationDate;
}
