package com.example.singlemind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);

        String username_str = username.getText().toString();
        String email_str = email.getText().toString();
        String password_str = password.getText().toString();

        // Here, get info from database and update singleton.
        Globals.getInstance().user = access.getUser(username_str).get();

        //Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }
}
