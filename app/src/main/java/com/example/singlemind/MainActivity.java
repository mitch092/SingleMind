package com.example.singlemind;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.singlemind.backend.Event.AccessObjects.EventAccess2;
import com.example.singlemind.backend.Event.TransferObjects.Events;
import com.example.singlemind.backend.User.AccessObjects.UserAccess;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.singlemind.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Called when the "Sign up" button is pressed.
    public void onSignUp(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    public void onForgot(View view){
        Intent intent = new Intent(this, ForgotPassActivity.class);
        startActivity(intent);
    }

    public void onLogin(View view){
        UserAccess access = new UserAccess();

        Intent intent = new Intent(this, EventListActivity.class);

        EditText username = (EditText) findViewById(R.id.username);
        EditText email = (EditText) findViewById(R.id.emailVal);
        EditText password = (EditText) findViewById(R.id.password);

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();
        String password_str = password.getText().toString();

        if(username_str.isEmpty() || email_str.isEmpty() || password_str.isEmpty())
            Toast.makeText(
                    MainActivity.this,
                    "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        else {
            try {
                // Here, get info from database and update singleton.
                Globals.getInstance().user = access.getUser(username_str).get();

                int uid = Globals.getInstance().user.getUserID();

                EventAccess2 eventDB = new EventAccess2();
                Events evnt;

                try {
                    evnt = new Events(eventDB.getEventsByUserId(uid).events);
                    if (!evnt.events.isEmpty())
                        startActivity(intent);
                    else {
                        intent = new Intent(this, AddEventActivity.class);
                        startActivity(intent);
                    }

                } catch (Exception e) {
                    Log.d("http_incoming_error", e.getMessage());
                    //intent = new Intent(this, AddEventActivity.class);
                    ActivityCompat.startActivityForResult(this, new Intent(this, AddEventActivity.class), 0, null);
                }

                //startActivity(intent);

            } catch (Exception e) {
                Toast.makeText(
                        MainActivity.this,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
