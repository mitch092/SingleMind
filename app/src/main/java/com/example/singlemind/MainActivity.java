package com.example.singlemind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }
}
