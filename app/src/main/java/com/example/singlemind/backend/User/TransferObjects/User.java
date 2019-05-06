package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDateTime;

public final class User extends NewUser {
    public User(int user_id, String username, String email,
                String first_name, String last_name,
                String phone, LocalDateTime creation_date){

        super(username, email, first_name, last_name, phone);
        this.UserId = user_id;
        this.CreationDate = creation_date;
    }


    public int getUserId() {
        return this.UserId;
    }
    public LocalDateTime getCreationDate() {
        return this.CreationDate;
    }


    private final int UserId;
    private final LocalDateTime CreationDate;
}
