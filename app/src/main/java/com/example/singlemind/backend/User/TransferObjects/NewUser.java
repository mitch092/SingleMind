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
    }
    public NewUser(){
        this.Username = "";
        this.LastName = "";
        this.FirstName = "";
        this.Email = "";
        this.PhoneNumber = "";
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

    public void setUsername(String username){ this.Username = username;}
    public void setLastName(String lastname){ this.LastName = lastname;}
    public void setFirstName(String firstname){ this.FirstName = firstname;}
    public void setEmail(String email){this.Email = email;}
    public void setPhoneNumber(String phone){this.PhoneNumber = phone;}



    protected String Username;
    protected String LastName;
    protected String FirstName;
    protected String Email;
    protected String PhoneNumber;
}
