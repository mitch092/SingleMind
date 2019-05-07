package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class User extends NewUser {
    public User(int UserID, String Username, String Email,
                String FirstName, String LastName,
                String PhoneNumber, LocalDateTime CreationDate){

        super(Username, Email, FirstName, LastName, PhoneNumber);
        this.UserID = UserID;
        this.CreationDate = CreationDate;
    }
    public User(){
        super();
        this.UserID = 0;
        this.CreationDate = null;
    }


    public int getUserID() {
        return this.UserID;
    }
    public LocalDateTime getCreationDate() {
        return this.CreationDate;
    }



    private final int UserID;
    private final LocalDateTime CreationDate;
}
