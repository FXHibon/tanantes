package org.maurange.formation.licpro;

import org.maurange.formation.licpro.rest.*;


import android.app.ListActivity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;


public class ListArretsActivity extends ListActivity implements MenuItem.OnMenuItemClickListener {

    private static String LOG_TAG = "ListArretsActivity";
    private GetListArretTask getListArretTask;
    private GetAttenteTask getAttenteTask;
    private LocationManager locationManager;
    private Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        update();
    }

    private void update() {
        getListArretTask = new GetListArretTask(this);
        /*
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location == null) {
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }


        getListArretTask.execute(location.getLatitude(), location.getLongitude());*/

        // Test data
        getListArretTask.execute(47.2271839, -1.569467);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        menu.getItem(0).setOnMenuItemClickListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "enregistrement des listeners");
        //TODO
    }

    //arret des updates
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "desenregistrement des listeners");
        //TODO
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        return false;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Arret currentArret = (Arret) l.getAdapter().getItem(position);
        getAttenteTask = new GetAttenteTask(this, currentArret.getCodeLieu());
        getAttenteTask.execute();
    }
}
