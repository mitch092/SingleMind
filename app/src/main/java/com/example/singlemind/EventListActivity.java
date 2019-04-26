package com.example.singlemind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

public class EventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
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
