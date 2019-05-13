package com.example.singlemind;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singlemind.backend.Event.AccessObjects.EventAccess2;
import com.example.singlemind.backend.Event.TransferObjects.Event;
import com.example.singlemind.backend.Event.TransferObjects.Events;

public class EventListActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    EventAccess2 eventDB = new EventAccess2();
    MyRecyclerViewAdapter adapter;
    int uid;
    Events events = new Events();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        uid = Globals.getInstance().user.getUserID();

        refreshEvents();
    }

    private void refreshEvents () {
        //try {
            events = eventDB.getEventsByUserId(uid);
            //Events e = new Events(events);

            // set up the RecyclerView
            RecyclerView recyclerView = findViewById(R.id.rvEvents);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new MyRecyclerViewAdapter(this, events);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        //} catch (Exception e) {
        //    Intent intent = new Intent(this, AddEventActivity.class);
        //    startActivity(intent);
        //}
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        Event selected = new Event();

        boolean minList = true;
        if(adapter.getItemCount() <= 1)
            minList = true;
        else minList = false;

        //Log.d("Recycler Item Counter", "" + adapter.getItemCount());

        if(!minList) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Event Options");
            builder.setMessage("Modify, Delete, or Cancel");

            /*builder.setPositiveButton("Modify",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //OnDialogCheck = true;
                        //modify or update event OR delete current event and call add event
                        int eid = adapter.getItem(position).getEventID();
                        eventDB.deleteEventByEventId(eid);
                        dialog.cancel();
                    }
                }
        );*/

            builder.setPositiveButton("Delete",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //delete event
                            //OnDialogCheck = false;
                            int eid = adapter.getItem(position).getEventID();
                            eventDB.deleteEventByEventId(eid);
                            refreshEvents();
                            dialog.cancel();
                        }
                    }
            );

            builder.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //OnDialogCheck = false;
                            dialog.cancel();
                        }
                    }
            );
            AlertDialog dialog = builder.create();
            //OnDialogCheck = true;
            dialog.show();
        }
    }

    public void onAcct(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void onAdd(View view){
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivity(intent);

        ActivityCompat.startActivityForResult(this, new Intent(this, AddEventActivity.class), 0, null);
    }

    /*public void onSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }*/

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //OnDialogCheck = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
