package com.ibs.delibery;

import android.app.Application;
import android.location.Location;

import java.util.ArrayList;
import java.util.List;

public class WalkStree extends Application {
    private static WalkStree singleton;

    private List<Location> myLocations;

    public List<Location> getMyLocations() {
        return myLocations;
    }

    public void setMyLocations(List<Location> myLocations) {
        this.myLocations = myLocations;
    }

    public WalkStree getInstance() {
        return singleton;
    }

    public void onCreate() {
        super.onCreate();
        singleton = this;
        myLocations = new ArrayList<>();

    }
}
