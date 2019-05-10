package com.example.singlemind;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.singlemind.backend.Event.AccessObjects.EventAccess;
import com.example.singlemind.backend.Event.TransferObjects.Event;

public class AddEventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

    }

    public void onAddEvent(View view) {
        EditText eventName = (EditText) findViewById(R.id.eventName);
        EditText eventDate = (EditText) findViewById(R.id.eventDate);
        EditText eventDesc = (EditText) findViewById(R.id.eventDesc);

        String name = eventName.getText().toString();
        String date = eventDate.getText().toString();
        String desc = eventDesc.getText().toString();

        int user_id = 0;
        /*
        //User new_user = new User();
        User user = new User(username_str, email_str, first_name_str, last_name_str, phone_str);
        UserAccessDatabase db = new UserAccessDatabase();
        db.addUser(user);
        */

        Event event = new Event(user_id, name, desc, date);
        EventAccess eventDB = new EventAccess();
        eventDB.addEvent(event);
    }
}
