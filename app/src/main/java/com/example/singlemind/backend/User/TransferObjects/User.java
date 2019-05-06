package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public final class User extends NewUser {
    public User(int user_id, String username, String email,
                String first_name, String last_name,
                String phone, LocalDateTime creation_date,
                Optional<LocalDate> birthdate){

        super(username, email, first_name, last_name, phone, birthdate);
        this.user_id = user_id;
        this.creation_date = creation_date;
    }


    public int getUserId() {
        return this.user_id;
    }
    public LocalDateTime getCreationDate() {
        return this.creation_date;
    }


    private final int user_id;
    private final LocalDateTime creation_date;
}
