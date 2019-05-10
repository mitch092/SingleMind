package com.example.singlemind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.singlemind.backend.User.AccessObjects.UserAccessDatabase;
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



        //User new_user = new User();



        User user = new User(username_str, email_str, first_name_str, last_name_str, phone_str);



        UserAccessDatabase db = new UserAccessDatabase();
        //db.addUser(user);

        Optional<User> bad_user = db.getUser("mitch");
        if(bad_user.isPresent()){
            Log.d("http_delete_user", "User ayyy was found.");
            Log.d("http_user_info", "User ayyy has name: " + bad_user.get().getUsername() + ". Id: " + bad_user.get().getUserID());
        }else {
            Log.d("http_delete_user","User ayyy was not found.");
        }
        db.deleteUser(db.getUser("ayyy").get().getUserID());

    }
}
