package com.example.singlemind.backend.User.TransferObjects;

public class NewUser {
    public NewUser(String username, String email,
                String first_name, String last_name,
                String phone) {
        this.Username = username;
        this.LastName = last_name;
        this.FirstName = first_name;
        this.Email = email;
        this.PhoneNumber = formatPhone(phone);
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

    private String formatPhone(String phone_str){
        return phone_str.replaceAll("[^\\d]", "" );
    }



    private final String Username;
    private final String LastName;
    private final String FirstName;
    private final String Email;
    private final String PhoneNumber;
}
