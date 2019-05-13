package com.example.singlemind;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.singlemind.backend.User.AccessObjects.UserAccess;
import com.example.singlemind.backend.User.TransferObjects.User;

public class AccountActivity extends AppCompatActivity {

    User acct = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        acct = Globals.getInstance().user;

        EditText username = findViewById(R.id.userNameVal);
        EditText email = findViewById(R.id.emailVal);
        EditText phone = findViewById(R.id.pboneNumVal);
        EditText fname = findViewById(R.id.firstNameVal);
        EditText lname = findViewById(R.id.lastNameVal);

        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        username.setText(acct.getUsername());
        email.setText(acct.getEmail());
        phone.setText(acct.getPhoneNumber());
        fname.setText(acct.getFirstName());
        lname.setText(acct.getLastName());

        username.setHint(acct.getUsername());
        email.setHint(acct.getEmail());
        phone.setHint(acct.getPhoneNumber());
        fname.setHint(acct.getFirstName());
        lname.setHint(acct.getLastName());
    }

    public void onSaveChanges(View view) {
        EditText username = findViewById(R.id.userNameVal);
        EditText email = findViewById(R.id.emailVal);
        EditText phone = findViewById(R.id.pboneNumVal);
        EditText fname = findViewById(R.id.firstNameVal);
        EditText lname = findViewById(R.id.lastNameVal);

        String u_str = username.getText().toString();
        String e_str = email.getText().toString();
        String p_str = phone.getText().toString();
        String f_str = fname.getText().toString();
        String l_str = lname.getText().toString();

        if(u_str.isEmpty() || e_str.isEmpty() || p_str.isEmpty() || f_str.isEmpty() || l_str.isEmpty())
            Toast.makeText(
                    AccountActivity.this,
                    "No Changes Made",
                    Toast.LENGTH_SHORT).show();
        else {
            Globals.getInstance().user.setUsername(u_str);
            Globals.getInstance().user.setEmail(e_str);
            Globals.getInstance().user.setPhoneNumber(p_str);
            Globals.getInstance().user.setFirstName(f_str);
            Globals.getInstance().user.setLastName(l_str);

            UserAccess db = new UserAccess();
            int uid = acct.getUserID();
            db.updateUserUsername(uid, u_str);
            db.updateUserEmail(acct, e_str);
            db.updateUserPhone(uid, p_str);
            db.updateUserFirstName(uid, f_str);
            db.updateUserLastName(uid, l_str);

            Intent intent = new Intent(this, EventListActivity.class);
            startActivity(intent);
        }
    }
}
