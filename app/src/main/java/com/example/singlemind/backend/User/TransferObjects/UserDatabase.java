package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDateTime;
import java.util.Optional;

public final class UserDatabase {
    public UserDatabase(int user_id, String username, String email,
                        String first_name, String last_name,
                        int phone, LocalDateTime creation_date,
                        Optional<LocalDateTime> birthdate) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.creation_date = creation_date;
        this.birthdate = birthdate;
    }


    public int getUserId() {
        return this.user_id;
    }

    public String getUsername() {
        return this.username;
    }


    public String getEmail() {return this.email; }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public int getPhone() {
        return this.phone;
    }

    public LocalDateTime getCreationDate() {
        return this.creation_date;
    }

    public Optional<LocalDateTime> getBirthdate() {
        return this.birthdate;
    }


    private final int user_id;
    private final String username;
    private final String email;
    private final String first_name;
    private final String last_name;
    private final int phone;
    private final LocalDateTime creation_date;
    private final Optional<LocalDateTime> birthdate;
}
