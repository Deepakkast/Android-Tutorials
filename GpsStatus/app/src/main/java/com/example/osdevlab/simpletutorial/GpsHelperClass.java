package com.example.osdevlab.simpletutorial;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * Created by osdevlab on 1/1/15.
 */

//we need to first implements LocationListener
//Four functions will be provided by IDE when implements LocationListener and we have to override those functions.
//For now, we don't need to override those functions yet.

public class GpsHelperClass implements LocationListener {

    protected LocationManager locationManager;
    Context context;

    //at constructor, context is passed from FragmentOne.java and context will be used by GpsHelperClass throughout.
    public GpsHelperClass(Context context) {
        this.context = context;
    }

    public boolean isGpsReadyToUse() {
        //this.context.getSystemService is required if we want to use in separate class
        locationManager = (LocationManager) this.context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
