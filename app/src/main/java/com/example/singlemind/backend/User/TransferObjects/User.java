package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDateTime;
import java.util.Optional;

public final class User {
    public User(UserFirebase firebase_user, UserDatabase database_user) {
        this.firebase = firebase_user;
        this.database = database_user;
    }


    public int getUserId() {
        return database.getUserId();
    }

    public String getUsername() {
        return database.getUsername();
    }

    public String getPassword() {
        return firebase.getPassword();
    }

    public String getEmail() {return database.getEmail(); }

    public String getFirstName() {
        return database.getFirstName();
    }

    public String getLastName() {
        return database.getLastName();
    }

    public int getPhone() {
        return database.getPhone();
    }

    public LocalDateTime getCreationDate() {
        return database.getCreationDate();
    }

    public Optional<LocalDateTime> getBirthdate() {
        return database.getBirthdate();
    }


    private final UserDatabase database;
    private final UserFirebase firebase;

}
