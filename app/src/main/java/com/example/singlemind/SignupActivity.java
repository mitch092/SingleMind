package com.example.singlemind;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.singlemind.backend.Event.AccessObjects.EventAccess2;
import com.example.singlemind.backend.Event.TransferObjects.Event;
import com.example.singlemind.backend.User.AccessObjects.UserAccess;
import com.example.singlemind.backend.User.TransferObjects.User;

import java.time.LocalDate;
import java.util.Optional;


public class SignupActivity extends AppCompatActivity {
    // For birthdates
    Optional<LocalDate> date = Optional.empty();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Add a special formatter to the phone edit text field.
        EditText phone = (EditText) findViewById(R.id.phone);
        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    public void onCreateUser(View view){

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        EditText password_validate = (EditText) findViewById(R.id.password_validate);
        EditText email = (EditText) findViewById(R.id.emailVal);
        EditText first_name = (EditText) findViewById(R.id.first_name);
        EditText last_name = (EditText) findViewById(R.id.last_name);
        EditText phone = (EditText) findViewById(R.id.phone);

        String username_str = username.getText().toString();
        String password_str = password.getText().toString();
        String password_validate_str = password_validate.getText().toString();
        String email_str = email.getText().toString();
        String first_name_str = first_name.getText().toString();
        String last_name_str = last_name.getText().toString();
        String phone_str = phone.getText().toString();

        if(username_str.isEmpty()
                || email_str.isEmpty()
                || password_str.isEmpty()
                || password_validate_str.isEmpty()
                || first_name_str.isEmpty()
                || last_name_str.isEmpty()
                || phone_str.isEmpty()) {
            Toast.makeText(
                    SignupActivity.this,
                    "No Event added",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            User user = new User(username_str, email_str, first_name_str, last_name_str, phone_str);
            UserAccess db = new UserAccess();
            db.addUser(user, password_str);

            int uid = user.getUserID();
            EventAccess2 eventDB = new EventAccess2();

            Event event = new Event(
                    uid,
                    "Hello New User!",
                    "Welcome to SingleMind! This is a placeholder Event to demonstrate the format. To Add a New Event, Tap the middle button at the Top of your Screen!",
                    "19-05-01 12:00:00");
            eventDB.addEvent(event);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
