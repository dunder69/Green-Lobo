package com.example.owner.greenlobo;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MapsActivity extends ActionBarActivity {

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

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.maps, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_both) {
            for(int i=0;i<waterFountains.size();i++){
                mMap.addMarker(waterFountains.get(i));
            }
            for(int i=0;i<recyclingBins.size();i++){
                mMap.addMarker(recyclingBins.get(i));
            }
            return true;
        }
        if (id == R.id.action_wf) {
            mMap.clear();
            for (int i = 0; i < waterFountains.size(); i++) {
                mMap.addMarker(waterFountains.get(i));
            }
            return true;
        }
        if (id == R.id.action_rb) {
            mMap.clear();
            for (int i = 0; i < recyclingBins.size(); i++) {
                    mMap.addMarker(recyclingBins.get(i));
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
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
    //compost
    //trash cans
    private void addWaterFountains(){
        //Casas
        waterFountains.add(new MarkerOptions().title("Water Fountain Casas Del Rio").snippet("In front office, behind gym and next to bathrooms").
                position(new LatLng(35.084616, -106.615332)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));

        //Centennial Engineering Center
        waterFountains.add(new MarkerOptions().title("Water Fountain CENT").snippet("First floor and basement, next to bathrooms").
                position(new LatLng(35.083028, -106.625633)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));

        //Dane Smith Hall
        waterFountains.add(new MarkerOptions().title("Water Fountain DSH").snippet("Along west wall on all floors, behind bathrooms").
                position(new LatLng(35.086315, -106.623596)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));
        waterFountains.add(new MarkerOptions().title("Water Fountain DSH").snippet("Second floor between east entrance doors")
                .position(new LatLng(35.086194, -106.622904)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));

        //Farris
        waterFountains.add(new MarkerOptions().title("Water Fountain FEC").snippet("Third floor, next to bathrooms").
                position(new LatLng(35.082268, -106.625394)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));


        //Johnson Gym
        waterFountains.add(new MarkerOptions().title("Water Johnson Gym").snippet("First floor, both inside and outside weight room").
                position(new LatLng(35.082358, -106.617406)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));
        waterFountains.add(new MarkerOptions().title("Water Johnson Gym").snippet("First floor, next to equipment room").
                position(new LatLng(35.082666, -106.618031)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));
        waterFountains.add(new MarkerOptions().title("Water Johnson Gym").snippet("First floor, main gym near doors").
                position(new LatLng(35.082451, -106.618388)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));

        //Popejoy
        waterFountains.add(new MarkerOptions().title("Water Popejoy").snippet("Basement, next to bathrooms").
                position(new LatLng(35.082335, -106.620303)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));

        //SMLC
        waterFountains.add(new MarkerOptions().title("Water SMLC").snippet("First floor, next to north wing bathrooms").
                position(new LatLng(35.084044, -106.624275)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));


        //SUB
        waterFountains.add(new MarkerOptions().title("Water SUB").snippet("Both floors next to stairs and bathrooms").
                position(new LatLng(35.083627, -106.620314)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));

        //Zimmerman Library
        waterFountains.add(new MarkerOptions().title("Water Fountain Zimmerman Library").snippet("First floor computer area next to bathrooms").
                position(new LatLng(35.084809, -106.620343)).icon(BitmapDescriptorFactory.fromResource(R.drawable.bluewatermarker)));
    }

    private void addRecyclingBins() {
        //Centennial Library
        recyclingBins.add(new MarkerOptions().title("Recycling Bin CENT").snippet("Centennial Library B1 next to stars and front desk").
                position(new LatLng(35.083166, -106.624088)).icon(BitmapDescriptorFactory.fromResource(R.drawable.greenrecyclingmarker)));

        //DSH
        recyclingBins.add(new MarkerOptions().title("Recycling Bin DSH").snippet("Second floor along east entrance hallway").
                position(new LatLng(35.086224, -106.622933)).icon(BitmapDescriptorFactory.fromResource(R.drawable.greenrecyclingmarker)));
        recyclingBins.add(new MarkerOptions().title("Recycling Bin DSH").snippet("First floor south hallway").
                position(new LatLng(35.086054, -106.623209)).icon(BitmapDescriptorFactory.fromResource(R.drawable.greenrecyclingmarker)));
        recyclingBins.add(new MarkerOptions().title("Recycling Bin DSH").snippet("First floor, PepsiCo recycling machine by outtakes").
                position(new LatLng(35.086139, -106.622953)).icon(BitmapDescriptorFactory.fromResource(R.drawable.greenrecyclingmarker)));


        //Duck Pond
        recyclingBins.add(new MarkerOptions().title("Recycling Bin Duck Pond").snippet("East pathway along Zimmerman Library").
                position(new LatLng(35.084856, -106.621803)).icon(BitmapDescriptorFactory.fromResource(R.drawable.greenrecyclingmarker)));

        //General Outside
        recyclingBins.add(new MarkerOptions().title("Recycling Bin ").snippet("Walkway by SMLC").
                position(new LatLng(35.084071, -106.623754)).icon(BitmapDescriptorFactory.fromResource(R.drawable.greenrecyclingmarker)));
        recyclingBins.add(new MarkerOptions().title("Recycling Bin").snippet("Walkway by Centennial Library").
                position(new LatLng(35.083326, -106.6239127)).icon(BitmapDescriptorFactory.fromResource(R.drawable.greenrecyclingmarker)));
    }
}
