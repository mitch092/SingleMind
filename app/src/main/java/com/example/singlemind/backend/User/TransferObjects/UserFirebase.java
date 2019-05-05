package com.example.singlemind.backend.User.TransferObjects;

public final class UserFirebase {
    public UserFirebase(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private final String email;
    private final String password;
}
