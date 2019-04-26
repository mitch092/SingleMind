package com.example.backend;

import java.time.LocalDateTime;
import java.util.Optional;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private int phone;
    private LocalDateTime creation_date;
    private Optional<LocalDateTime> birthdate;


    private User(int user_id, String username, String password,
                 String first_name, String last_name,
                 int phone, LocalDateTime creation_date,
                 Optional<LocalDateTime> birthdate) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.creation_date = creation_date;
        this.birthdate = birthdate;
    }


    // The only way to get User objects is to fetch pre-made users. This function only makes new users.
    // It does not return a User object. For that, use "returnUserByUsername" or "returnUserById"
    // The boolean is an error code that shows if the user was successfully added or not.
    //public static Boolean addUser() {

    //}


    public int getUserId() {
        return this.user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

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
}
