package com.ibs.delibery;

import android.location.Location;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class ShowSavedLocationsList extends AppCompatActivity {

    ListView lv_savedLocations;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_saved_locations_list);

        lv_savedLocations = findViewById(R.id.lv_wayPoints);

        WalkStree walkStree = (WalkStree) getApplicationContext();
        List<Location> savedLocations = walkStree.getMyLocations();

        lv_savedLocations.setAdapter(new ArrayAdapter<Location>( this, android.R.layout.simple_list_item_1, savedLocations));

    }
}
