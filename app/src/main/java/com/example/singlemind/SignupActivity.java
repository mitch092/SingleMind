package com.example.singlemind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.singlemind.backend.User.AccessObjects.UserAccessDatabase;
import com.example.singlemind.backend.User.TransferObjects.NewUser;

import java.time.LocalDate;
import java.time.Month;
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
        EditText email = (EditText) findViewById(R.id.email);
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

        Log.d("phone", phone_str);

        /*

        //User new_user = new User();



        NewUser user = new NewUser();



        UserAccessDatabase db = new UserAccessDatabase();
        String URL = getParent().getApplicationContext().getResources().getString(R.string.user_http)
        db.addUser(URL, user);
        */
    }



    public void showDatePickerDialog(View view){
        DialogFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "datePicker");
        fragment.show(getSupportFragmentManager(), "datePicker");
    }
}
