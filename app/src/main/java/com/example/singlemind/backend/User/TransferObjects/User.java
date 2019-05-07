package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class User extends NewUser {
    public User(int user_id, String username, String email,
                String first_name, String last_name,
                String phone, String creation_date){

        super(username, email, first_name, last_name, phone);
        this.UserID = user_id;
        this.CreationDate = creation_date;
    }
    public User(){
        super();
        this.UserID = 0;
        this.CreationDate = "";
    }


    public int getUserID() {
        return this.UserID;
    }
    public String getCreationDate() {
        return this.CreationDate;
    }

    public LocalDateTime getCreationDateFormatted(){
        return LocalDateTime.parse(this.getCreationDate(), DateTimeFormatter.RFC_1123_DATE_TIME);
    }


    private final int UserID;
    private final String CreationDate;
}
