package com.example.owner.greenlobo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private ArrayList<MarkerOptions> recyclingBins = new ArrayList<>();
    private ArrayList<MarkerOptions> waterFountains = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        LatLng unmCoordinates = new LatLng(35.084399, -106.619553);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(unmCoordinates, 16);
        mMap.animateCamera(yourLocation);

        //Add Water Fountains
        addWaterFountains();
        for(int i=0;i<waterFountains.size();i++){
            mMap.addMarker(waterFountains.get(i));
        }

        //Add Recycling Bins
        addRecyclingBins();
        for(int i=0;i<recyclingBins.size();i++){
            mMap.addMarker(recyclingBins.get(i));
        }


        //mMap.addMarker(new MarkerOptions().position(new LatLng(35.0839, 106.6186)).title("UNM"));
    }

    private void addWaterFountains(){
        //Dane Smith Hall
        waterFountains.add(new MarkerOptions().title("Water Fountain DSH").snippet("Along west wall on all floors, behind bathrooms").
                position(new LatLng(35.086315, -106.623596)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));
        waterFountains.add(new MarkerOptions().title("Water Fountain DSH").snippet("Second floor between east entrance doors")
                .position(new LatLng(35.086194, -106.622904)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));

        //Zimmerman Library
        waterFountains.add(new MarkerOptions().title("Water Fountain Zimmerman").snippet("First floor computer area next to bathrooms").
                position(new LatLng(35.084809, -106.620343)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));
    }

    private void addRecyclingBins() {
        recyclingBins.add(new MarkerOptions().title("Recycling Bin DSH").snippet("Second floor along east entrance hallway").
                position(new LatLng(35.086224, -106.622933)).icon(BitmapDescriptorFactory.fromResource(R.drawable.greenrecyclingmarker)));
    }
}
