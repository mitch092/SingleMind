package com.example.singlemind.backend.User.TransferObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    public User(String Username, String Email,
                String FirstName, String LastName,
                String PhoneNumber){

        this.Username = Username;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber.replaceAll("[^\\d]", "" );
        this.UserID = -1;
        this.CreationDate = "";
    }
    public User(){
        this.Username = "";
        this.LastName = "";
        this.FirstName = "";
        this.Email = "";
        this.PhoneNumber = "";
        this.UserID = -1;
        this.CreationDate = "";
    }

    public String getUsername() {
        return this.Username;
    }
    public String getLastName() {
        return this.LastName;
    }
    public String getFirstName() {
        return this.FirstName;
    }
    public String getEmail() {return this.Email; }
    public String getPhoneNumber() {
        return this.PhoneNumber;
    }
    public int getUserID() {
        return this.UserID;
    }
    public String getCreationDate() {
        return this.CreationDate;
    }

    public void setUsername(String username){ this.Username = username;}
    public void setLastName(String lastname){ this.LastName = lastname;}
    public void setFirstName(String firstname){ this.FirstName = firstname;}
    public void setEmail(String email){this.Email = email;}
    public void setPhoneNumber(String phone){this.PhoneNumber = phone;}

    private String Username;
    private String LastName;
    private String FirstName;
    private String Email;
    private String PhoneNumber;
    private int UserID;
    private String CreationDate;
}
