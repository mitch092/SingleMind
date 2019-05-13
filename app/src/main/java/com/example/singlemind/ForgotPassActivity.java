package com.example.singlemind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        EditText email = (EditText) findViewById(R.id.emailFP);
    }

    public void onSubmit(View view){
        EditText email = (EditText) findViewById(R.id.emailFP);
        String eml = email.getText().toString();
        if(eml.isEmpty())
            Toast.makeText(
                    ForgotPassActivity.this,
                    "No Email",
                    Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
