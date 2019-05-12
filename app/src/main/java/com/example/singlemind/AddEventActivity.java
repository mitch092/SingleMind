package com.example.singlemind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.singlemind.backend.Event.AccessObjects.EventAccess2;
import com.example.singlemind.backend.Event.TransferObjects.Event;

public class AddEventActivity extends AppCompatActivity {

    int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        uid = Globals.getInstance().user.getUserID();
    }

    public void onAddEvent(View view) {
        EditText eventName = (EditText) findViewById(R.id.eventName);
        EditText eventDate = (EditText) findViewById(R.id.eventDate);
        EditText eventDesc = (EditText) findViewById(R.id.eventDesc);

        String name = eventName.getText().toString();
        String date = eventDate.getText().toString();
        String desc = eventDesc.getText().toString();

        /*
        //User new_user = new User();
        User user = new User(username_str, email_str, first_name_str, last_name_str, phone_str);
        UserAccessDatabase db = new UserAccessDatabase();
        db.addUser(user);
        */

        Event event = new Event(uid, name, desc, date);
        EventAccess2 eventDB = new EventAccess2();
        eventDB.addEvent(event);

        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }
}
