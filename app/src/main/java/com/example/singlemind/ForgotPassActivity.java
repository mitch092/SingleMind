package com.example.singlemind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        EditText email = (EditText) findViewById(R.id.emailVal);
    }

    public void onSubmit(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
