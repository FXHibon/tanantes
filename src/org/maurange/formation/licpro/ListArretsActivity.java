package org.maurange.formation.licpro;

import java.util.ArrayList;

import org.maurange.formation.licpro.rest.*;


import android.app.ListActivity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;


public class ListArretsActivity extends ListActivity {

    private static String LOG_TAG = "ListArretsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Arret> data = new ArrayList<Arret>();
        ArretRestMethod rest = new ArretRestMethod(this);
        GetListArretTask task = new GetListArretTask(this);
        task.execute(47.2271839, -1.569467);

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

}
