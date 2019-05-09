package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class User extends NewUser {
    public User(int UserID, String Username, String Email,
                String FirstName, String LastName,
                String PhoneNumber, String CreationDate){

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
    public String getCreationDate() {
        return this.CreationDate;
    }



    protected final int UserID;
    protected final String CreationDate;
}
