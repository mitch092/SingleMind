package com.example.singlemind;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singlemind.backend.Event.AccessObjects.EventAccess;
import com.example.singlemind.backend.Event.TransferObjects.Event;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    EventAccess eventDB = new EventAccess();
    MyRecyclerViewAdapter adapter;
    ArrayList<Event> events = new ArrayList<>();
    int uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);

        uid = Globals.getInstance().user.getUserID();

        //test objects
        /*events.add(new Event(2, "Birthday", "Billy's Birthday", "19-05-17 12:00:00"));
        events.add(new Event(2, "Job Interview", "Meeting at Business Corp.", "19-05-20 08:00:00"));
        events.add(new Event(2, "Date", "Go out for Coffee", "19-05-21 10:00:00"));
        events.add(new Event(2, "Doctors Appt.", "Physical", "19-05-20 15:30:00"));
        events.add(new Event());*/

        refreshEvents();
    }

    private void refreshEvents () {
        //Events events = new Events(eventDB.getEventsByUserID(uid));
        events = eventDB.getEventsByUserID(uid);
        //Events e = new Events(events);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, events);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        Event selected = new Event();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Event Options");
        builder.setMessage("Modify, Delete, or Cancel");

        builder.setPositiveButton("Modify",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //modify or update event OR delete current event and call add event

                        dialog.cancel();
                    }
                }
        );

        builder.setNeutralButton("Delete",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //delete event

                        dialog.cancel();
                    }
                }
        );

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
                );
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onAcct(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }
    public void onAdd(View view){
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivity(intent);
    }
    public void onSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
