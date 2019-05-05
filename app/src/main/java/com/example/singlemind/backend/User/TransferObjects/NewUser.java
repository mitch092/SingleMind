package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDateTime;
import java.util.Optional;

public class NewUser {
    public NewUser(String username, String email,
                String first_name, String last_name,
                int phone, Optional<LocalDateTime> birthdate) {
        this.username = username;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return this.username;
    }
    public String getLastName() {
        return this.last_name;
    }
    public String getFirstName() {
        return this.first_name;
    }
    public String getEmail() {return this.email; }
    public int getPhone() {
        return this.phone;
    }
    public Optional<LocalDateTime> getBirthdate() {
        return this.birthdate;
    }



    private final String username;
    private final String last_name;
    private final String first_name;
    private final String email;
    private final int phone;
    private final Optional<LocalDateTime> birthdate;

}
