package com.example.singlemind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onCreateUser(View view){
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        EditText password_validate = (EditText) findViewById(R.id.password_validate);
        EditText email = (EditText) findViewById(R.id.username);
        EditText first_name = (EditText) findViewById(R.id.first_name);
        EditText last_name = (EditText) findViewById(R.id.last_name);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText birthdate = (EditText) findViewById(R.id.birthdate);





        //User new_user = new User();
    }
}
