package com.example.singlemind.backend.User.TransferObjects;

public class NewUser {
    public NewUser(String Username, String Email,
                String FirstName, String LastName,
                String PhoneNumber) {
        this.Username = Username;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber.replaceAll("[^\\d]", "" );
        this.BirthDate = "";
    }
    public NewUser(){
        this.Username = "";
        this.LastName = "";
        this.FirstName = "";
        this.Email = "";
        this.PhoneNumber = "";
        this.BirthDate = "";
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
    public String getBirthDate() {return this.BirthDate;}



    protected final String Username;
    protected final String LastName;
    protected final String FirstName;
    protected final String Email;
    protected final String PhoneNumber;
    protected final String BirthDate;
}
